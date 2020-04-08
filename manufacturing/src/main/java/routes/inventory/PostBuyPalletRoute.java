package routes.inventory;

import inventory.PalletInventory;
import spark.*;

public class PostBuyPalletRoute implements Route {

    private PalletInventory palletInventory;

    public PostBuyPalletRoute(PalletInventory palletInventory){
        this.palletInventory = palletInventory;
    }

    public Object handle(Request request, Response response){
        String warehouse_loc = request.queryParams("warehouse_loc");
        int numBoxes = Integer.parseInt(request.queryParams("boxquantity"));

        palletInventory.purchasePallet(numBoxes,warehouse_loc);

        response.type("GET");
        response.redirect("/inventory");
        return null;
    }
}
