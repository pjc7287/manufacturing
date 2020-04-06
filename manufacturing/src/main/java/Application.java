import database.Database;
import routes.WebServer;

import spark.Spark;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

public class Application {

    public static void main(String[] args){

        final TemplateEngine templateEngine = new FreeMarkerEngine();
        final Database db = new Database();

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });

        WebServer server = new WebServer(templateEngine, db);
    }
}
