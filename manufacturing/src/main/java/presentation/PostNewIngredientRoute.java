package presentation;

import data.Database;
import domain.Ingredient;
import domain.Recipe;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/recipes/new". We will respond with a rendered HTML page
 */
public class PostNewIngredientRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public PostNewIngredientRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        if(request.queryParams("rid")!=null) {
            System.out.println("made it here @@@@@@@@@@@@@@@");
            String part_id = request.queryParams("part_id");
            String recipe_id = request.queryParams("rid");
            String part_name = request.queryParams("part_name");
            String quantity = request.queryParams("quantity");
            String desc = request.queryParams("part_desc");
            Ingredient newIngredient = new Ingredient(Integer.parseInt(part_id), Integer.parseInt(recipe_id), part_name, Integer.parseInt(quantity), desc);
            db.getIngredientTable().addIngredient(newIngredient);
        }

        Map<String, Object> attributeMap = new HashMap<>();
        return templateEngine.render(new ModelAndView(attributeMap , "newrecipe.ftl"));
    }

}
