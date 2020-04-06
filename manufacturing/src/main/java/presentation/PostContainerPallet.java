package presentation;

import data.Database;
import domain.Container;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostContainerPallet implements  Route {

    private TemplateEngine templateEngine;
    private Database db;

    public PostContainerPallet(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        if(request.queryParams("cont_id")!=null) {
            String containerId = request.queryParams("cont_id");
            String palletId = request.queryParams("pallet_id");
            db.getContainersTable().updateContainerPallet(containerId, palletId);
        }
        else {
            System.out.println("Something went wrong :/");
        }


        //re-render
        List<List<String>> table = new ArrayList<>();
        List<Container> containers = db.getContainersTable().getAllContainers();

        for(Container c:containers){
            table.add(c.toList());
        }

        attributeMap.put("table", table);

        return templateEngine.render(new ModelAndView(attributeMap , "InvManagement.ftl"));
    }
}
