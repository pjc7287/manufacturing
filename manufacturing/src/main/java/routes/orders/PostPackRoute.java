package routes.orders;

import assembly.AssemblyLine;
import database.Database;
import database.InDevProductsTable;
import database.sql2o.InDevProduct;
import database.sql2o.WorkOrder;
import spark.*;
import java.util.UUID;

import java.util.HashMap;

/**
 * This class is responsible for handling a POST request to "/orders/new". We will save the order and redirect to the order page
 */
public class PostPackRoute implements Route {

    private Database db;

    public PostPackRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){

        //Fetch workorder id
        String id = request.queryParams("workorder_id");
        //Fetch workorder
        WorkOrder wo = db.getWorkOrderTable().getWorkOrder(id);
        InDevProduct prod = db.getInDevProductsTable().getProduct(wo.getProduct_id());
        //Delete workorder/product from tables
        db.getWorkOrderTable().deleteWorkOrder(wo.getId());
        db.getInDevProductsTable().removeProduct(prod.getSerial_num());

        //Put workorder into inventory
        response.type("GET");
        response.redirect("/orders");
        return null;

    }

}
