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

        //HTML page reequests
        get("/", new GetHomeRoute(templateEngine));

        get("/recipes", new GetRecipesRoute(templateEngine, db));
        post("/recipes", new PostNewRecipeRoute(templateEngine, db));
        get("/recipes/new", new GetNewRecipeRoute(templateEngine));
        post("/recipes/new", new PostNewIngredientRoute(templateEngine, db));
        get("/recipes/info/:rid", new GetRecipeInfoRoute(templateEngine,db));

        get("/orders", new GetOrdersRoute(templateEngine, db));

        get("/warehouse", new GetWarehouseRoute(templateEngine));



        //Test requests
        get("/hello", (req, res) -> "Hello World");

    }
}
