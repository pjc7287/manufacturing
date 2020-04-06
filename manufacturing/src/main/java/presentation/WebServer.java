package presentation;

import data.Database;
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

        //HTML page requests
        get("/", new GetHomeRoute(templateEngine));

        get("/recipes", new GetRecipesRoute(templateEngine, db));
        post("/recipes", new PostNewRecipeRoute(templateEngine, db));
        get("/recipes/new", new GetNewRecipeRoute(templateEngine));
        post("/recipes/new", new PostNewIngredientRoute(templateEngine, db));
        get("/recipes/info/:rid", new GetRecipeInfoRoute(templateEngine,db));

        get("/orders", new GetOrdersRoute(templateEngine, db));

        get("/warehouse", new GetWarehouseRoute(templateEngine));

        get("/inventory", new GetPartsRoute(templateEngine, db));

        get("/product", new GetProductRoute(templateEngine, db));

        get("/pallet", new GetPalletRoute(templateEngine, db));

        get("/container", new GetContainerRoute(templateEngine, db));

        get("/InvManagement", new GetInvManagementRoute(templateEngine, db));
        post("/InvManagement", new PostContainerPallet(templateEngine, db));
        post("/InvManagement", new PostProductContainer(templateEngine, db));
        post("/InvManagement", new PostPartsContainer(templateEngine, db));



        //Test requests
        get("/hello", (req, res) -> "Hello World");

    }
}

