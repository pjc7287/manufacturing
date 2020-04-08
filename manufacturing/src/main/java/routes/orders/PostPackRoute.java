package routes.orders;

import assembly.AssemblyLine;
import database.Database;
import database.InDevProductsTable;
import database.sql2o.InDevProduct;
import database.sql2o.Product;
import database.sql2o.WorkOrder;
import inventory.PalletInventory;
import spark.*;
import java.util.UUID;

import java.util.HashMap;

/**
 * This class is responsible for handling a POST request to "/orders/new". We will save the order and redirect to the order page
 */
public class PostPackRoute implements Route {

    private Database db;
    private PalletInventory palletInventory;

    public PostPackRoute(PalletInventory palletInventory, Database db){
        this.palletInventory = palletInventory;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        //Fetch workorder id
        String id = request.queryParams("workorder_id");
        //Fetch workorder
        WorkOrder wo = db.getWorkOrderTable().getWorkOrder(id);
        InDevProduct prod = db.getInDevProductsTable().getProduct(wo.getProduct_id());

        Product packedProd = new Product(prod.getProduct_id(),prod.getSerial_num(),prod.getWarehouse_loc(),"null");
        palletInventory.packProduct(packedProd);

        //Delete workorder/product from tables
        db.getWorkOrderTable().deleteWorkOrder(wo.getId());
        db.getInDevProductsTable().removeProduct(prod.getSerial_num());

        //Put workorder into inventory
        response.type("GET");
        response.redirect("/inventory");
        return null;

    }

}
