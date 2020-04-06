package routes;

import assembly.AssemblyLine;
import database.Database;
import routes.orders.GetNewOrderRoute;
import routes.orders.GetOrdersRoute;
import routes.catalog.*;
import routes.orders.PostNewOrderRoute;
import routes.warehouse.*;
import spark.TemplateEngine;

import static spark.Spark.*;

public class WebServer {

    private TemplateEngine templateEngine;
    private Database db;
    private AssemblyLine assemblyLine;

    public WebServer(TemplateEngine templateEngine, Database db, AssemblyLine assemblyLine){
        this.templateEngine = templateEngine;
        this.db = db;
        this.assemblyLine = assemblyLine;
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

        // CATALOG ROUTES:
        get("/catalog", new GetCatalogRoute(templateEngine, db));
        get("/catalog/new/define_product", new GetDefineProductRoute(templateEngine, db));
        get("/catalog/new/define_part", new GetDefinePartRoute(templateEngine));
        get("/catalog/info/:id", new GetProductInfoRoute(templateEngine,db));
        post("/catalog/new/part", new PostNewPartRoute(db));
        post("/catalog/new/product", new PostNewProductRoute(db));

        //ORDER ROUTES
        get("/orders", new GetOrdersRoute(templateEngine, db));
        get("/orders/new_order", new GetNewOrderRoute(templateEngine, db));
        post("/orders/new", new PostNewOrderRoute(db, assemblyLine));




        get("/warehouse", new GetWarehouseRoute(templateEngine));
        get("/inventory", new GetPartsRoute(templateEngine, db));
        get("/product", new GetProductRoute(templateEngine, db));
        get("/pallet", new GetPalletRoute(templateEngine, db));
        get("/container", new GetContainerRoute(templateEngine, db));



        //Test requests
        get("/hello", (req, res) -> "Hello World");

    }
}

