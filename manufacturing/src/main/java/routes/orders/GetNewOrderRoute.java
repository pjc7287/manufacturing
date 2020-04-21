package routes.orders;

import database.Database;
import database.sql2o.ProductDefinition;
import spark.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/orders/new_order". We will respond with a rendered HTML page
 */
public class GetNewOrderRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;


    public GetNewOrderRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){
        Session userSession = request.session();
        if(userSession.attribute("signedIn")=="true"){
            //Get the list of parts and put their ids and names into a hash for the page to render
            HashMap<String, String> productsInfo = new HashMap<>();

            List<ProductDefinition> products = db.getProductDefinitionsTable().getAllProducts();

            for(ProductDefinition product : products){
                productsInfo.put(product.getId(), product.getTitle());
            }

            Map<String, Object> attributeMap = new HashMap<>();

            attributeMap.put("productsInfo", productsInfo);

            return templateEngine.render(new ModelAndView(attributeMap , "orders/new_order.ftl"));
        }
        else{
            return templateEngine.render(new ModelAndView(new HashMap<String,Object>() , "signin.ftl"));
        }
    }
}
