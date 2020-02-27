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

        get("/", new GetHomeRoute(templateEngine));

        get("/hello", (req, res) -> "Hello World");

    }
}
