package presentation;

import data.Database;
import domain.Pallet;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/pallet". We will respond with a rendered HTML page
 */
public class GetPalletRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetPalletRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> table = new ArrayList<>();
        System.out.println("Getting pallets...");
        List<Pallet> pallets = db.getPalletsTable().getAllPallets();
        System.out.println("Pallets received");

        for(Pallet p:pallets){
            table.add(p.toList());
        }

        attributeMap.put("table", table);

        //Todo: GET ALL RECIPES FROM DB, Put into spark and print them in a table in ftl file!!

        return templateEngine.render(new ModelAndView(attributeMap , "pallet.ftl"));
    }
}
