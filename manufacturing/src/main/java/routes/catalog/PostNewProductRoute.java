package routes.catalog;

import database.Database;
import database.sql2o.ProductDefinition;
import spark.*;

import java.util.HashMap;
import java.util.UUID;

/**
 * This class is responsible for handling a POST request to "/catalog/new/part". We will save the part and redirect to the catalogue page
 */
public class PostNewProductRoute implements Route {


    private Database db;

    public PostNewProductRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){

        //Fetch product information
        String title = request.queryParams("title");
        String cost = request.queryParams("cost");
        String category = request.queryParams("category");
        String info = request.queryParams("info");
        String serial_id = UUID.randomUUID().toString();
        //Fetch number of components
        int numComponents = Integer.parseInt(request.queryParams("partCount"));

        ProductDefinition newProduct = new ProductDefinition(serial_id, title, Float.parseFloat(cost), category, info);
        HashMap<String, Integer> componentInfo = new HashMap<>();
        for(int i = 1; i <= numComponents; i++){
            String index = Integer.toString(i);
            String partID = request.queryParams("part_id"+index);
            int quantity = Integer.parseInt(request.queryParams("quantity"+index));
            componentInfo.put(partID, quantity);
        }

        db.getProductDefinitionsTable().addProduct(newProduct, componentInfo);

        response.type("GET");
        response.redirect("/catalog");
        return null;
    }

}
