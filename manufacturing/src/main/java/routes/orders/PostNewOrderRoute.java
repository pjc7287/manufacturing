package routes.orders;

import database.Database;
import database.InDevProductsTable;
import database.sql2o.InDevProduct;
import spark.*;
import java.util.UUID;

import java.util.HashMap;

/**
 * This class is responsible for handling a POST request to "/orders/new". We will save the order and redirect to the order page
 */
public class PostNewOrderRoute implements Route {

    private Database db;

    public PostNewOrderRoute(Database db){
        this.db = db;
    }

    public Object handle(Request request, Response response){

        System.out.println("Post to new product detected");
        //Fetch product information

        String command = request.queryParams("command");
        if (command.equals("assemble")) {

            String product_id = request.queryParams("product_id");
            String warehouse_loc = request.queryParams("warehouse_loc");
            String info = request.queryParams("info");

            int quantity = Integer.parseInt(request.queryParams("quantity"));

            InDevProductsTable products_table = db.getInDevProductsTable();
            for(int i = 0; i<quantity; i++){
                //Create UUIDs for each product and submit the indev products to the database
                String serial_num = UUID.randomUUID().toString();
                InDevProduct newProduct = new InDevProduct(Integer.parseInt(product_id), serial_num, warehouse_loc);
                products_table.addNewProduct(newProduct);
            }

            //TODO: Add work order to queue in assembly simulation

            //TODO: Add work order to database

            //Redirect to orders

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
