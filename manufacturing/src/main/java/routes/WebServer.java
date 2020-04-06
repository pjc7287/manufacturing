package routes;

import database.Database;
import routes.orders.GetNewOrderRoute;
import routes.orders.GetOrdersRoute;
import routes.catalog.*;
import routes.warehouse.*;
import spark.TemplateEngine;

import static spark.Spark.*;

public class WebServer {

    private TemplateEngine templateEngine;
    private Database db;

    public WebServer(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
        this.initializeRoutes();
    }

    /**
     * Initializes routes, and also starts a webserver
     */
    private void initializeRoutes(){

        // Configuration to serve static files
        staticFileLocation("/public");

        //HTML page reequests
        get("/", new GetHomeRoute(templateEngine));

        // Rendering catalog module pages:
        get("/catalog", new GetCatalogRoute(templateEngine, db));
        get("/catalog/new/define_product", new GetDefineProductRoute(templateEngine, db));
        get("/catalog/new/define_part", new GetDefinePartRoute(templateEngine));
        get("/catalog/info/:id", new GetProductInfoRoute(templateEngine,db));

        post("/catalog/new/part", new PostNewPartRoute(db));
        post("/catalog/new/product", new PostNewProductRoute(db));



        get("/orders", new GetOrdersRoute(templateEngine, db));
        get("/orders/new_order", new GetNewOrderRoute(templateEngine, db));

        get("/warehouse", new GetWarehouseRoute(templateEngine));

        get("/inventory", new GetPartsRoute(templateEngine, db));

        get("/product", new GetProductRoute(templateEngine, db));

        get("/pallet", new GetPalletRoute(templateEngine, db));

        get("/container", new GetContainerRoute(templateEngine, db));



        //Test requests
        get("/hello", (req, res) -> "Hello World");

    }
}

