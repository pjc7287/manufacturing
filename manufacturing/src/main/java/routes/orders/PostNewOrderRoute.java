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

        System.out.println("Post to new product detected");
        //Fetch product information

        String command = request.queryParams("command");
        if (command.equals("assemble")) {

            String product_id = request.queryParams("product_id");
            String warehouse_loc = request.queryParams("warehouse_loc");
            String info = request.queryParams("info");

            //Add new product to the indev_product table
            String serial_num = UUID.randomUUID().toString();
            InDevProduct newProduct = new InDevProduct(Integer.parseInt(product_id), serial_num, warehouse_loc);
            db.getInDevProductsTable().addNewProduct(newProduct);

            //TODO LIST FOR 4/6/2020:

            //Workorders:
            //TODO: REFACTOR the workorder database, orders page, new_order page,  to get rid of quantity and instead have a progress field.
            //TODO: Initialize the progress of any new work order to 0, and add it to the assembly line.
            //TODO: Then have the assembly line create Operation objects for new work orders and add them to ther queue.
            //TODO: Whenever a workorder/operation gets popped off the qeue, calculate the amount of steps based on nmumber of parts
            //TODO: Update the percentage of progress by dividing 100/steps and update the database with the new information
            //TODO: Now, refreshing the orders page should update the status of the work order
            //TODO: Whenever a work order gets completed, delete the work order, delete the product from indev and assign it to a container and move it to inventory
            //TODO: This will be dependent on how inventory is implemeneted and how much work jake has finished so far
            //TODO: From there, items can get shipped.
            //TODO: In the future we might want to track completed orders for whatever reason but thats out of our current scope

            //Login:
            //TODO as far as logging in, just add conditionals based on permission attribute to all ftl. Manager should be able to edit everything/delete/add.
            //TODO: Employee permission should not.
            //TODO: Refactor the home page to be a sign in first, and make it super simple.

            //Inventory:.
            //TODO: Inventory needs to track what products we have
            //TODO: Products will sit in a container of their own type. (Max 100 per container)
            //TODO: Containers will be on pallets (Max 8 per pallet)
            //TODO: Products going to same warehouse as other products will be placed in boxes with other space if possible
            //TODO: If no other box exists, create a new box
            //TODO: Same operation goes with boxes-pallets. boxes will go on pallets with other boxes going to the same place
            //TODO: For R2 we will have a button on the pallets page allowing the pallets to be "shipped" to their warehouse. this will effectivley just remove the pallet, its boxes, and its products
            //TODO: from our inventory
            //TODO: Need views displaying pallets. Clicking on a pallet will indicate what boxes are in it. Clicking on a box indicates what products are in it.
            //TODO: On pallet page ,next to each pallet there will be a "ship" button that removes the pallet from our inventory
            //TODO: additionally, we might want to automatically ship 100% filled pallets. but this will probably not be seen in our demo so mayeb not worth effort

            //Budget:
            //TODO: If we have time, we will just have a tab that allows you to view the "budget" for the warehouse
            //TODO: it will have a hardcoded breakdown of all of our expenses. (New boxes = money, New containers = money, etc etc)


            //Add work order to workorder table
            WorkOrder workOrder = new WorkOrder(-1, command, 0,product_id, warehouse_loc, info);

            //TODO: Add work order to queue in assembly simulation

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
