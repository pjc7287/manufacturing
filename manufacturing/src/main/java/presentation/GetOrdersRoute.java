package presentation;

import data.Database;
import domain.WorkOrder;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/orders". We will respond with a rendered HTML page
 */
public class GetOrdersRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetOrdersRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> table = new ArrayList<>();
        System.out.println("Getting work orders...");
        List<WorkOrder> orders = db.getWorkOrderTable().getAllWorkOrders();
        System.out.println("Work orders received");

        for(WorkOrder w:orders){
            table.add(w.toList());
        }

        attributeMap.put("table", table);

        //Todo: GET ALL RECIPES FROM DB, Put into spark and print them in a table in ftl file!!

        return templateEngine.render(new ModelAndView(attributeMap , "orders.ftl"));
    }

}
