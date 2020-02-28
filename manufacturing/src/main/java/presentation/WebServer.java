package presentation;

import spark.TemplateEngine;

import static spark.Spark.*;

public class WebServer {

    private TemplateEngine templateEngine;

    public WebServer(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
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
        get("/recipes", new GetRecipesRoute(templateEngine));
        get("/orders", new GetOrdersRoute(templateEngine));
        get("/warehouse", new GetWarehouseRoute(templateEngine));

        //Test requests
        get("/hello", (req, res) -> "Hello World");

    }
}
