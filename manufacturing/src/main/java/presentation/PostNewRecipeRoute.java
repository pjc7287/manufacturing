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
public class PostNewRecipeRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public PostNewRecipeRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();
        //This if-else logic should work for now for differenting between adding recipe post/delete recipe post
        //Fix this later though!! Very sloppy
        if(request.queryParams("title")!=null) {
            String recipename = request.queryParams("title");
            String recipeid = request.queryParams("id");
            String prodid = request.queryParams("prod_id");
            String desc = request.queryParams("desc");
            Recipe newRecipe = new Recipe(Integer.parseInt(recipeid), recipename, Integer.parseInt(prodid),desc);
            db.getRecipeTable().addRecipe(newRecipe);
        }
        else if(request.queryParams("delete_id")!=null){
            String delete_id = request.queryParams("delete_id");
            db.getIngredientTable().deleteRecipeIngredients(Integer.parseInt(delete_id));
            db.getRecipeTable().deleteRecipe(Integer.parseInt(delete_id));
        }

        //Re-render the recipes now
        List<List<String>> table = new ArrayList<>();
        List<Recipe> recipes = db.getRecipeTable().getAllRecipes();
        for(Recipe r:recipes){
            table.add(r.toList());
        }
        attributeMap.put("table", table);

        return templateEngine.render(new ModelAndView(attributeMap , "recipes.ftl"));
    }

}
