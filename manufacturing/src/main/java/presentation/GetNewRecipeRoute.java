package presentation;

import data.Database;
import domain.Recipe;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/recipes/new". We will respond with a rendered HTML page
 */
public class GetNewRecipeRoute implements Route {

    private TemplateEngine templateEngine;

    public GetNewRecipeRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();
        return templateEngine.render(new ModelAndView(attributeMap , "newrecipe.ftl"));
    }

}
