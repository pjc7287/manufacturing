package routes.catalog;

import database.Database;
import database.sql2o.PartDefinition;
import spark.*;

/**
 * This class is responsible for handling a POST request to "/catalog/new/part". We will save the part and redirect to the catalogue page
 */
public class PostNewPartRoute implements Route {

    private Database db;

    public PostNewPartRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){


        String title = request.queryParams("title");
        String cost = request.queryParams("cost");
        String info = request.queryParams("info");
        //ID Will be updated by database. Need throaway value for now
        PartDefinition newPart = new PartDefinition(-1,  title, Float.parseFloat(cost) , info);

        db.getPartDefinitionsTable().addPart(newPart);

        response.type("GET");
        response.redirect("/catalog");
        return null;
    }

}
