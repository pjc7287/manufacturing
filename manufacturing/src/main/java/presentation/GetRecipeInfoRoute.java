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
 * This class is responsible for handling a GET request to "/orders". We will respond with a rendered HTML page
 */
public class GetRecipeInfoRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetRecipeInfoRoute(TemplateEngine templateEngine, Database db){
        this.db = db;
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        int rid = Integer.parseInt(request.params(":rid"));

        Recipe r = db.getRecipeTable().getRecipe(rid).get(0);

        attributeMap.put("rid",r.getId());
        attributeMap.put("rname",r.getName());
        attributeMap.put("pid",r.getProd_id());
        attributeMap.put("desc",r.getDesc());

        List<List<String>> table = new ArrayList<>();
        List<Ingredient> items = db.getIngredientTable().getRecipeIngredients(rid);
        for(Ingredient i:items){
            table.add(i.toList());
        }
        attributeMap.put("table", table);


        return templateEngine.render(new ModelAndView(attributeMap , "recipeinfo.ftl"));
    }

}
