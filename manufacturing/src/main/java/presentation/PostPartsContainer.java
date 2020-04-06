package presentation;

import data.Database;
import domain.Part;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostPartsContainer implements Route {


    private TemplateEngine templateEngine;
    private Database db;

    public PostPartsContainer(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        System.out.println("Here--------------");

        if(request.queryParams("serial_num")!=null) {
            String serial_num = request.queryParams("serial_num");
            String containerId = request.queryParams("cont_id");
            db.getPartsTable().updatePartContainer(serial_num, containerId);
        }
        else {
            System.out.println("Something went wrong :/");
        }


        //re-render
        List<List<String>> table = new ArrayList<>();
        List<Part> parts = db.getPartsTable().getAllParts();

        for(Part p:parts){
            table.add(p.toList());
        }

        attributeMap.put("table", table);

        return templateEngine.render(new ModelAndView(attributeMap , "InvManagement.ftl"));
    }
}
