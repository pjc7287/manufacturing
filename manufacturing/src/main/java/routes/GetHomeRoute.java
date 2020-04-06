package routes;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/". We will respond with a rendered HTML page
 */
public class GetHomeRoute implements Route {

    private TemplateEngine templateEngine;

    public GetHomeRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();
        attributeMap.put("somevariablename","VariableValue");
        return templateEngine.render(new ModelAndView(attributeMap , "index.ftl"));
    }

}
