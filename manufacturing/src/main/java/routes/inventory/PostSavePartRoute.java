package routes.inventory;

import database.sql2o.Part;
import database.Database;
import spark.*;

import java.util.UUID;

public class PostSavePartRoute implements Route {

    private Database db;

    public PostSavePartRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){

        String part_id = request.queryParams("part_id");
        String serial_num = UUID.randomUUID().toString();
        Part part = new Part(part_id, serial_num);
        db.getPartInventoryTable().addPart(part);


        response.type("GET");
        response.redirect("/inventory/part_inventory");
        return null;
    }
}
