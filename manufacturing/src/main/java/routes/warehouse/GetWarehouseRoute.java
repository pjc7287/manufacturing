package routes.warehouse;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/warehouse". We will respond with a rendered HTML page
 */
public class GetWarehouseRoute implements Route {

    private TemplateEngine templateEngine;

    public GetWarehouseRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();
        return templateEngine.render(new ModelAndView(attributeMap , "warehouse.ftl"));
    }

}
