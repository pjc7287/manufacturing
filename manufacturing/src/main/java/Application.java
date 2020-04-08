import assembly.AssemblyLine;
import database.Database;
import inventory.PalletInventory;
import routes.WebServer;

import spark.Spark;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

public class Application {

    public static void main(String[] args){

        //Singleton Classes
        final TemplateEngine templateEngine = new FreeMarkerEngine();
        final Database db = new Database();
        final AssemblyLine assemblyLine = new AssemblyLine(db);
        final PalletInventory palletInventory = new PalletInventory(db);

        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });

        new WebServer(templateEngine, db, assemblyLine, palletInventory);
    }
}
