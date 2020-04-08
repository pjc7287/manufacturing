package routes.inventory;

import database.Database;
import database.sql2o.Part;
import database.sql2o.PrettyPrintPart;
import database.sql2o.ProductDefinition;
import database.sql2o.PartDefinition;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/catalog". We will respond with a rendered HTML page listing all parts and products
 */
public class GetPartInventoryRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetPartInventoryRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> part_table = new ArrayList<>();

        List<PrettyPrintPart> parts = db.getPartInventoryTable().getAllPartsFormatted();

        for(PrettyPrintPart part:parts){
            part_table.add(part.toList());
        }

        attributeMap.put("part_table", part_table);

        return templateEngine.render(new ModelAndView(attributeMap , "inventory/part_inventory.ftl"));
    }

}

