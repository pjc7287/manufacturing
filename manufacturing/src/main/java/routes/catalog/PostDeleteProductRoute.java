package routes.catalog;

import database.Database;
import spark.Request;
import spark.Response;
import spark.Route;

public class PostDeleteProductRoute implements Route {

    private Database db;

    public PostDeleteProductRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){

        String product_id = request.queryParams("product_id");
        db.getProductDefinitionsTable().deleteProduct(product_id);

        response.type("GET");
        response.redirect("/catalog");
        return null;
    }
}
