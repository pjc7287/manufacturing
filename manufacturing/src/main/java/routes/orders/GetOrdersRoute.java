package routes.orders;

import assembly.AssemblyMessageBox;
import database.Database;
import database.sql2o.WorkOrder;
import spark.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
        Session userSession = request.session();
        if(userSession.attribute("signedIn")=="true"){
            Map<String, Object> attributeMap = new HashMap<>();

            List<List<String>> table = new ArrayList<>();
            List<WorkOrder> orders = db.getWorkOrderTable().getAllWorkOrders();

            for(WorkOrder w:orders){
                table.add(w.toList());
            }

            attributeMap.put("table", table);
            attributeMap.put("assemblyMessage", AssemblyMessageBox.message);
            attributeMap.put("permissions", userSession.attribute("permissions"));

            return templateEngine.render(new ModelAndView(attributeMap , "orders/orders.ftl"));
        }
        else{
            return templateEngine.render(new ModelAndView(new HashMap<String,Object>() , "signin.ftl"));
        }
    }

}
