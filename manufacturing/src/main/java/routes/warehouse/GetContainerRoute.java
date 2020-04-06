package routes.warehouse;

import database.Database;
import database.sql2o.Container;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/container". We will respond with a rendered HTML page
 */
public class GetContainerRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetContainerRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> table = new ArrayList<>();
        System.out.println("Getting containers...");
        List<Container> containers = db.getContainersTable().getAllContainers();
        System.out.println("Containers received");

        for(Container c:containers){
            table.add(c.toList());
        }

        attributeMap.put("table", table);

        return templateEngine.render(new ModelAndView(attributeMap , "container.ftl"));
    }
}

