package routes.catalog;

import database.Database;
import database.sql2o.Component;
import database.sql2o.ProductDefinition;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/orders". We will respond with a rendered HTML page
 */
public class GetProductInfoRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetProductInfoRoute(TemplateEngine templateEngine, Database db){
        this.db = db;
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Session userSession = request.session();
        if(userSession.attribute("signedIn")=="true"){
            Map<String, Object> attributeMap = new HashMap<>();

            String id = request.params(":id");

            ProductDefinition product = db.getProductDefinitionsTable().getProduct(id);

            attributeMap.put("id",product.getId());
            attributeMap.put("title",product.getTitle());
            attributeMap.put("cost",product.getCost());
            attributeMap.put("category",product.getCategory());
            attributeMap.put("info",product.getInfo());

            List<List<String>> table = new ArrayList<>();

            List<Component> components = db.getProductDefinitionsTable().getComponents(id);
            for(Component c:components){
                table.add(c.toList());
            }
            attributeMap.put("table", table);


            return templateEngine.render(new ModelAndView(attributeMap , "catalog/product_info.ftl"));
        }
        else{
            return templateEngine.render(new ModelAndView(new HashMap<String,Object>() , "signin.ftl"));
        }

    }

}
