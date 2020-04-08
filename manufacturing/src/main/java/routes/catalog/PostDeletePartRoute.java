package routes.catalog;

import database.Database;
import spark.Request;
import spark.Response;
import spark.Route;

public class PostDeletePartRoute implements Route {

    private Database db;

    public PostDeletePartRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){

        String part_id = request.queryParams("part_id");
        db.getPartDefinitionsTable().deletePart(part_id);

        response.type("GET");
        response.redirect("/catalog");
        return null;
    }
}
