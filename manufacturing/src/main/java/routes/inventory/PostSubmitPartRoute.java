package routes.inventory;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import database.Database;
import database.sql2o.Part;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.UUID;

public class PostSubmitPartRoute implements Route {

    private Database db;
    private Gson gson;

    private static final String jsonSyntaxErrorMessage = "Invalid body syntax. (JSON formatting error)";
    private static final String successfulMessage = "Part received succesfully";
    private static final String invalidPartID = "Part not found in catalog. ID must map to existing part";


    public PostSubmitPartRoute(Database db, Gson gson){
        this.db = db;
        this.gson = gson;
    }

    public Object handle(Request request, Response response){

        String json = request.body();
        try {
            Part part = gson.fromJson(json, Part.class);
            if(db.getPartDefinitionsTable().getPart(part.getPart_id())==null){
                response.status(400);
                response.body(invalidPartID);
                return response.body();
            }
            db.getPartInventoryTable().addPart(part);
            response.status(200);
            response.body(successfulMessage);
            return response.body();
        }
        catch(JsonSyntaxException jse){
            response.status(400);
            response.body(jsonSyntaxErrorMessage);
            return response.body();
        }
    }
}
