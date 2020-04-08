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
public class PostNewOrderRoute implements Route {

    private Database db;
    private AssemblyLine assemblyLine;

    public PostNewOrderRoute(Database db, AssemblyLine assemblyLine){
        this.db = db;
        this.assemblyLine = assemblyLine;
    }

    public Object handle(Request request, Response response){

        //Fetch product information

        String command = request.queryParams("command");
        if (command.equals("assemble")) {

            String product_id = request.queryParams("product_id");
            String warehouse_loc = request.queryParams("warehouse_loc");
            String info = request.queryParams("info");

            //Add new product to the indev_product table
            String serial_num = UUID.randomUUID().toString();
            InDevProduct newProduct = new InDevProduct(product_id, serial_num, warehouse_loc);
            db.getInDevProductsTable().addNewProduct(newProduct);
            //Add work order to workorder table
            String order_id = UUID.randomUUID().toString();
            WorkOrder workOrder = new WorkOrder(order_id, command, 0,warehouse_loc, serial_num, info);
            db.getWorkOrderTable().addWorkOrder(workOrder);
            //Add order to assembyline
            assemblyLine.addOrder(workOrder,newProduct);

            response.type("GET");
            response.redirect("/orders");
        }
        else if (command.equals("fix")){
                //TODO: Not implemented yet (need to add option to front end first)
        }
        else if(command.equals("dissassemble")){
                //TODO: Not implemented yet (need to add option to front end first)
        }
        else{
            System.out.println("Invalid order submitted: field \"command\".");
            response.redirect("/orders");
        }
        return null;

    }

}
