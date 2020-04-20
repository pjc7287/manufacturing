package routes.orders;

import assembly.AssemblyLine;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import database.Database;
import database.InDevProductsTable;
import database.sql2o.InDevProduct;
import database.sql2o.WorkOrder;
import routes.gson.APIWorkOrder;
import spark.*;
import java.util.UUID;

import java.util.HashMap;

/**
 * This class is responsible for handling a POST request to "/orders/new". We will save the order and redirect to the order page
 */
public class PostSubmitOrderRoute implements Route {

    private Database db;
    private AssemblyLine assemblyLine;
    private Gson gson;

    private static final String jsonSyntaxErrorMessage = "Invalid body syntax. (JSON formatting error)";
    private static final String invalidCommandMessage = "Invalid command type. Must be \"assemble\", \"fix\", or \"disassemble\".";
    private static final String invalidProductID = "Product not found in catalog. ID must map to existing product";

    public PostSubmitOrderRoute(Database db, AssemblyLine assemblyLine, Gson gson){
        this.db = db;
        this.assemblyLine = assemblyLine;
        this.gson = gson;
    }

    public Object handle(Request request, Response response){
        APIWorkOrder gsonOrder = null;
        String json = request.body();
        try{
            gsonOrder = gson.fromJson(json, APIWorkOrder.class);
        }
        catch(JsonSyntaxException jse){
            //Invalid body syntax
            response.status(400);
            response.body(jsonSyntaxErrorMessage);
            return response.body();
        }

        if (gsonOrder.getCommand().equals("assemble")) {

            String product_id = gsonOrder.getProduct_id();
            String warehouse_loc = gsonOrder.getWarehouse_loc();
            String info = gsonOrder.getInfo();

            if(db.getProductDefinitionsTable().getProduct(product_id) == null){
                //Product id is not valid
                response.type("application/json");
                response.status(400);
                response.body(invalidProductID);
                return response.body();
            }
            //Add new product to the indev_product table
            String serial_num = UUID.randomUUID().toString();
            InDevProduct newProduct = new InDevProduct(product_id, serial_num, warehouse_loc);
            db.getInDevProductsTable().addNewProduct(newProduct);
            //Add work order to workorder table
            String order_id = UUID.randomUUID().toString();
            WorkOrder workOrder = new WorkOrder(order_id, "assemble", 0,warehouse_loc, serial_num, info);
            db.getWorkOrderTable().addWorkOrder(workOrder);
            //Add order to assembyline
            assemblyLine.addOrder(workOrder,newProduct);

            response.status(200);
            response.body("Work order received");
        }
        else if (gsonOrder.getCommand().equals("fix")){
            //TODO: Not implemented yet
        }
        else if(gsonOrder.getCommand().equals("dissassemble")){
            //TODO: Not implemented yet
        }
        else{
            response.status(400);
            response.body(invalidCommandMessage);
            return response.body();
        }
        return response.body();

    }

}
