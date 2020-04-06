package presentation;

import data.Database;
import domain.Product;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostProductContainer implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public PostProductContainer(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        if(request.queryParams("serial_num")!=null) {
            System.out.println("Here");
            String serial_num = request.queryParams("serial_num");
            String containerId = request.queryParams("cont_id");
            db.getProductTable().updateProductContainer(serial_num, containerId);
        }
        else {
            System.out.println("Something went wrong :/");
        }

        List<List<String>> table = new ArrayList<>();
        List<Product> products = db.getProductTable().getAllProducts();

        for(Product p:products){
            table.add(p.toList());
        }

        attributeMap.put("table", table);

        return templateEngine.render(new ModelAndView(attributeMap , "InvManagement.ftl"));
    }
}
