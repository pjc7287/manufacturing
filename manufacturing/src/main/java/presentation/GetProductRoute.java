package presentation;

import data.Database;
import domain.Product;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/product". We will respond with a rendered HTML page
 */
public class GetProductRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetProductRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> table = new ArrayList<>();
        System.out.println("Getting products...");
        List<Product> products = db.getProductTable().getAllProducts();
        System.out.println("Products received");

        for(Product p:products){
            table.add(p.toList());
        }

        attributeMap.put("table", table);

        return templateEngine.render(new ModelAndView(attributeMap , "product.ftl"));
    }
}

