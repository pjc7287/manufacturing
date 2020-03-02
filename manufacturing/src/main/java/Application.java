import data.Database;
import presentation.WebServer;

import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

public class Application {



    public static void main(String[] args){

        final TemplateEngine templateEngine = new FreeMarkerEngine();
        final Database db = new Database();

        WebServer server = new WebServer(templateEngine, db);
    }
}
