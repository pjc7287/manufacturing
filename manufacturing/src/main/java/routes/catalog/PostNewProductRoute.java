package routes.catalog;

import database.Database;
import database.sql2o.ProductDefinition;
import spark.*;

import java.util.HashMap;

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
        //Fetch number of components
        int numComponents = Integer.parseInt(request.queryParams("partCount"));

        ProductDefinition newProduct = new ProductDefinition(-1, title, Float.parseFloat(cost), category, info);
        HashMap<Integer, Integer> componentInfo = new HashMap<>();
        for(int i = 1; i <= numComponents; i++){
            String index = Integer.toString(i);
            int partID = Integer.parseInt(request.queryParams("part_id"+index));
            int quantity = Integer.parseInt(request.queryParams("quantity"+index));
            componentInfo.put(partID, quantity);
        }

        db.getProductDefinitionsTable().addProduct(newProduct, componentInfo);

        response.type("GET");
        response.redirect("/catalog");
        return null;
    }

}
