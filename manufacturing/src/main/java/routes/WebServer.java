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

import static spark.Spark.*;

public class WebServer {

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
        this.initializeRoutes();
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
        post("/inventory/submit_part", new PostSubmitPartRoute(db));
        post("/inventory/ship_pallet", new PostShipPalletRoute(db));
        get("/inventory/part_inventory", new GetPartInventoryRoute(templateEngine,db));
        get("/inventory/box/:id", new GetBoxInfoRoute(templateEngine,db));


        //BUDGET ROUTES
        get("/budget", new GetBudgetRoute(templateEngine,db));

        //HEARTBEAT ROUTE
        post("/heartbeat", new PostHeartbeatRoute(assemblyLine));
        get("/heartbeat", (Request r, Response re) ->  "heartbeat found");
    }
}

