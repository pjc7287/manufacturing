package routes.inventory;

import database.Database;
import database.sql2o.Container;
import database.sql2o.PartDefinition;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/catalog/new". We will respond with a rendered HTML page
 */
public class GetNewPartRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;


    public GetNewPartRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        //Get the list of parts and put their ids and names into a hash for the page to render
        HashMap<String, String> partsInfo = new HashMap<>();

        List<PartDefinition> parts = db.getPartDefinitionsTable().getAllParts();
        for(PartDefinition part : parts){
            partsInfo.put(part.getId(), part.getTitle());
        }

        Map<String, Object> attributeMap = new HashMap<>();

        attributeMap.put("partsInfo", partsInfo);

        return templateEngine.render(new ModelAndView(attributeMap , "inventory/new_part.ftl"));
    }

}
