package routes;

import assembly.AssemblyLine;
import database.Database;
import inventory.PalletInventory;
import routes.budget.GetBudgetRoute;
import routes.heartbeat.PostHeartbeatRoute;
import routes.orders.GetNewOrderRoute;
import routes.orders.GetOrdersRoute;
import routes.catalog.*;
import routes.orders.PostNewOrderRoute;
import routes.inventory.*;
import routes.orders.PostPackRoute;
import spark.TemplateEngine;

import static spark.Spark.*;

public class WebServer {

    private TemplateEngine templateEngine;
    private Database db;
    private AssemblyLine assemblyLine;
    private PalletInventory palletInventory;

    public WebServer(TemplateEngine templateEngine, Database db, AssemblyLine assemblyLine, PalletInventory palletInventory){
        this.templateEngine = templateEngine;
        this.db = db;
        this.assemblyLine = assemblyLine;
        this.palletInventory = palletInventory;
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

        //ORDER ROUTES
        get("/orders", new GetOrdersRoute(templateEngine, db));
        get("/orders/new_order", new GetNewOrderRoute(templateEngine, db));
        post("/orders/new", new PostNewOrderRoute(db, assemblyLine));
        post("/orders/pack", new PostPackRoute(db));

        //INVENTORY ROUTES
        get("/inventory", new GetInventoryRoute(templateEngine,palletInventory));
        get("/inventory/new_pallet", new GetNewPalletRoute(templateEngine));
        post("/inventory/buy_pallet", new PostBuyPalletRoute(palletInventory));

        //BUDGET ROUTES
        get("/budget", new GetBudgetRoute(templateEngine,db));

        //HEARTBEAT ROUTE
        post("/heartbeat", new PostHeartbeatRoute(assemblyLine));
    }
}

