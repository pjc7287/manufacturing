package presentation;

import data.Cell;
import data.Table;
import data.TableRow;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/recipes". We will respond with a rendered HTML page
 */
public class GetRecipesRoute implements Route {

    private TemplateEngine templateEngine;

    public GetRecipesRoute(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();
        attributeMap.put("variablename","Peter");


        int p = 0;
        ArrayList<TableRow> rows = new ArrayList<>();
        for(int i = 0; i <100; i++){
            ArrayList<Cell> row = new ArrayList<>();
            for(int j = 0; j<10; j++){
                Cell c = new Cell("Data "+ Integer.toString(p++));
                row.add(c);
            }
            TableRow tablerow = new TableRow(row);
            rows.add(tablerow);
        }
        Table table = new Table(rows);

        attributeMap.put("table",table);

        return templateEngine.render(new ModelAndView(attributeMap , "recipes.ftl"));
    }

}
