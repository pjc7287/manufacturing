import presentation.WebServer;

import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

public class Application {



    public static void main(String[] args){

        final TemplateEngine templateEngine = new FreeMarkerEngine();

        WebServer server = new WebServer(templateEngine);
    }
}
