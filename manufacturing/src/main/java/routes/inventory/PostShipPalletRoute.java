package routes.inventory;

import database.sql2o.Part;
import database.Database;
import spark.*;

import java.util.UUID;

public class PostShipPalletRoute implements Route {

    private Database db;

    public PostShipPalletRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){

        String pallet_id = request.queryParams("pallet_id");
        db.getPalletInventoryTable().shipPallet(pallet_id);

        response.type("GET");
        response.redirect("/inventory");
        return null;
    }
}
