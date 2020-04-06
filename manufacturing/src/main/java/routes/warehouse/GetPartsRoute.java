package routes.warehouse;

import database.Database;
import database.sql2o.Part;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/parts". We will respond with a rendered HTML page
 */
public class GetPartsRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetPartsRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> table = new ArrayList<>();
        System.out.println("Getting parts...");
        List<Part> parts = db.getPartsTable().getAllParts();
        System.out.println("Parts received");

        for(Part p:parts){
            table.add(p.toList());
        }

        attributeMap.put("table", table);

        //Todo: GET ALL RECIPES FROM DB, Put into spark and print them in a table in ftl file!!

        return templateEngine.render(new ModelAndView(attributeMap , "inventory.ftl"));
    }
}

