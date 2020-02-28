package presentation;

import spark.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/". We will respond with a rendered HTML page
 */
public class GetRecipesRoute implements Route {

    private TemplateEngine templateEngine;

    public GetRecipesRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();
        attributeMap.put("variablename","Peter");
        return templateEngine.render(new ModelAndView(attributeMap , "recipes.ftl"));
    }

}
