package routes.inventory;

import database.Database;
import database.sql2o.Pallet;
import inventory.PalletInventory;
import inventory.PalletView;
import spark.*;

import java.util.*;

/**
 * This class is responsible for handling a GET request to "/pallet". We will respond with a rendered HTML page
 */
public class GetInventoryRoute implements Route {

    private TemplateEngine templateEngine;
    private PalletInventory palletInventory;

    public GetInventoryRoute(TemplateEngine templateEngine, PalletInventory palletInventory){
        this.templateEngine = templateEngine;
        this.palletInventory = palletInventory;
    }

    public Object handle(Request request, Response response){

        Session userSession = request.session();
        if(userSession.attribute("signedIn")=="true"){
            Map<String, Object> attributeMap = new HashMap<>();

            Map<String, List<String>> palletHash = new HashMap<>();

            List<PalletView> palletViews = palletInventory.getPalletViews();
            attributeMap.put("palletViews", palletViews);
            attributeMap.put("permissions", userSession.attribute("permissions"));

            return templateEngine.render(new ModelAndView(attributeMap , "inventory/inventory.ftl"));
        }
        else{
            return templateEngine.render(new ModelAndView(new HashMap<String,Object>() , "signin.ftl"));
        }
    }
}

