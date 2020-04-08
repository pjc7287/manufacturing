package routes.inventory;

import database.Database;
import database.sql2o.*;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/orders". We will respond with a rendered HTML page
 */
public class GetBoxInfoRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetBoxInfoRoute(TemplateEngine templateEngine, Database db){
        this.db = db;
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        String id = request.params(":id");

        Container container = db.getContainerInventoryTable().getContainer(id);

        attributeMap.put("container_id",container.getSerial_num());
        attributeMap.put("pallet_id",container.getPallet_id());
        attributeMap.put("warehouse_loc",container.getWarehouse_loc());

        List<List<String>> table = new ArrayList<>();

        List<PrettyPrintProduct> products = db.getProductInventoryTable().getContainersProducts(id);
        for(PrettyPrintProduct p:products){
            table.add(p.toList());
        }
        attributeMap.put("table", table);


        return templateEngine.render(new ModelAndView(attributeMap , "inventory/box_info.ftl"));
    }

}
