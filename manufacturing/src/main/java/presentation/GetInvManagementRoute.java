package presentation;

import data.Database;
import domain.Container;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetInvManagementRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetInvManagementRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> table = new ArrayList<>();
        System.out.println("Getting inventory...");
        List<Container> containers = db.getContainersTable().getAllContainers();
        System.out.println("Inventory received");

        for(Container c:containers){
            table.add(c.toList());
        }

        attributeMap.put("table", table);

        return templateEngine.render(new ModelAndView(attributeMap , "InvManagement.ftl"));
    }
}