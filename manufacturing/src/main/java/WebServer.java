import static spark.Spark.*;

public class WebServer {

    public WebServer(){
        this.initializeRoutes();
    }

    /**
     * Initializes routes, and also starts a webserver
     */
    private void initializeRoutes(){

        get("/hello", (req, res) -> "Hello World");

    }
}
