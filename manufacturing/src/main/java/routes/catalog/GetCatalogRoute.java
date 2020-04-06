package routes.catalog;

import database.Database;
import database.sql2o.ProductDefinition;
import database.sql2o.PartDefinition;
import spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is responsible for handling a GET request to "/catalog". We will respond with a rendered HTML page listing all parts and products
 */
public class GetCatalogRoute implements Route {

    private TemplateEngine templateEngine;
    private Database db;

    public GetCatalogRoute(TemplateEngine templateEngine, Database db){
        this.templateEngine = templateEngine;
        this.db = db;
    }

    public Object handle(Request request, Response response){

        Map<String, Object> attributeMap = new HashMap<>();

        List<List<String>> product_table = new ArrayList<>();
        List<List<String>> part_table = new ArrayList<>();

        List<ProductDefinition> products = db.getProductDefinitionsTable().getAllProducts();
        List<PartDefinition> parts = db.getPartDefinitionsTable().getAllParts();
        for(ProductDefinition product:products){
            product_table.add(product.toList());
        }
        for(PartDefinition part:parts){
            part_table.add(part.toList());
        }

        attributeMap.put("product_table", product_table);
        attributeMap.put("part_table", part_table);
        attributeMap.put("permissions", "MANAGER");

        return templateEngine.render(new ModelAndView(attributeMap , "catalog/catalog.ftl"));
    }

}

