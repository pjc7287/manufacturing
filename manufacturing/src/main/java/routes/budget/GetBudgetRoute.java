package routes.budget;

import database.Database;
import database.sql2o.Pallet;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/pallet". We will respond with a rendered HTML page
 */
public class GetBudgetRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetBudgetRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();



        return templateEngine.render(new ModelAndView(attributeMap , "budget/budget.ftl"));
    }
}

