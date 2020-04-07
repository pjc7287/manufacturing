package routes.inventory;

import database.Database;
import database.sql2o.Pallet;
import spark.*;

import java.util.*;

/**
 * This class is responsible for handling a GET request to "/pallet". We will respond with a rendered HTML page
 */
public class GetInventoryRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetInventoryRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        Map<String, List<String>> palletHash = new HashMap<>();

        for(int i = 0; i <10; i++){
            ArrayList<String> boxIds = new ArrayList<>();
            for(int j=0; j<4;j++){
                String boxID = UUID.randomUUID().toString();
                boxIds.add(boxID);
            }
            String palletID = UUID.randomUUID().toString();
            palletHash.put(palletID,boxIds);
        }
        attributeMap.put("palletHash", palletHash);

        return templateEngine.render(new ModelAndView(attributeMap , "inventory/inventory.ftl"));
    }
}

