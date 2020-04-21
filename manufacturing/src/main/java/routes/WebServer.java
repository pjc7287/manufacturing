package routes;

import assembly.AssemblyLine;
import com.google.gson.Gson;
import database.Database;
import inventory.PalletInventory;
import routes.budget.GetBudgetRoute;
import routes.heartbeat.PostHeartbeatRoute;
import routes.orders.*;
import routes.catalog.*;
import routes.inventory.*;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class WebServer {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
    private TemplateEngine templateEngine;
    private Database db;
    private AssemblyLine assemblyLine;
    private PalletInventory palletInventory;
    private Gson gson;

    public WebServer(TemplateEngine templateEngine, Database db, AssemblyLine assemblyLine, PalletInventory palletInventory, Gson gson){
        this.templateEngine = templateEngine;
        this.db = db;
        this.assemblyLine = assemblyLine;
        this.palletInventory = palletInventory;
        this.gson = gson;
        try {
            this.initializeHeartbeat();
        }
        catch(Exception e){
            System.out.println("Exception in registering heartbeat. Please restart system and try agian.");
        }
        this.initializeRoutes();
    }

    private void initializeHeartbeat() throws Exception {

        // form parameters
        Map<Object, Object> data = new HashMap<>();
        data.put("department", "manufacturing");
        data.put("url", "http://192.168.1.2:4567/heartbeat");

        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormDataFromMap(data))
                .uri(URI.create("https://accountingwebapp.azurewebsites.net/register"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

    }

    private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        System.out.println(builder.toString());
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }


    /**
     * Initializes routes, and also starts a webserver
     */
    private void initializeRoutes(){

        // Configuration to serve static files
        staticFileLocation("/public");

        //HOME ROUTE
        get("/", new GetHomeRoute(templateEngine));

        // CATALOG ROUTES:
        get("/catalog", new GetCatalogRoute(templateEngine, db));
        get("/catalog/new/define_product", new GetDefineProductRoute(templateEngine, db));
        get("/catalog/new/define_part", new GetDefinePartRoute(templateEngine));
        get("/catalog/info/:id", new GetProductInfoRoute(templateEngine,db));
        post("/catalog/new/part", new PostNewPartRoute(db));
        post("/catalog/new/product", new PostNewProductRoute(db));
        post("/catalog/delete/part", new PostDeletePartRoute(db));
        post("/catalog/delete/product", new PostDeleteProductRoute(db));


        //ORDER ROUTES
        get("/orders", new GetOrdersRoute(templateEngine, db));
        get("/orders/new_order", new GetNewOrderRoute(templateEngine, db));
        post("/orders/new", new PostNewOrderRoute(db, assemblyLine));
        post("/orders/pack", new PostPackRoute(palletInventory, db));
        post("/orders/submit_order", new PostSubmitOrderRoute(db, assemblyLine, gson));

        //INVENTORY ROUTES
        get("/inventory", new GetInventoryRoute(templateEngine,palletInventory));
        get("/inventory/new_pallet", new GetNewPalletRoute(templateEngine));
        post("/inventory/buy_pallet", new PostBuyPalletRoute(palletInventory));
        get("/inventory/new_part", new GetNewPartRoute(templateEngine, db));
        post("/inventory/save_part", new PostSavePartRoute(db));
        post("/inventory/ship_pallet", new PostShipPalletRoute(db));
        get("/inventory/part_inventory", new GetPartInventoryRoute(templateEngine,db));
        get("/inventory/box/:id", new GetBoxInfoRoute(templateEngine,db));
        post("/inventory/submit_part", new PostSubmitPartRoute(db, gson));


        //BUDGET ROUTES
        get("/budget", new GetBudgetRoute(templateEngine,db));

        //HEARTBEAT ROUTE
        post("/heartbeat", new PostHeartbeatRoute(assemblyLine));
        get("/heartbeat", (Request r, Response re) ->  "heartbeat found");
    }
}

