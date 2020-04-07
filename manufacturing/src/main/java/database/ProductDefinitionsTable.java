package database;

import database.sql2o.Component;
import database.sql2o.ProductDefinition;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import java.util.HashMap;
import java.util.List;

/**
 * Data Access Object (DAO) used to access the product_definitions table
 */
public class ProductDefinitionsTable {


    private Sql2o sql2o;

    public ProductDefinitionsTable(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    /**
     * Gets all of the products from the database and populates a list with ProductDefinition objects
     * @return List<ProductDefinition> list - List of ProductDefinition objects representing the table
     */
    public List<ProductDefinition> getAllProducts(){
        //
        String sql =
                "SELECT id, title, cost, category, info " +
                        "FROM product_definitions";

        try(Connection con = sql2o.open()) {
            List<ProductDefinition> result = con.createQuery(sql).executeAndFetch(ProductDefinition.class);
            con.close();
            return result;
        }
    }

    /**
     * Gets product definition based on id
     * @return ProductDefinition product - the product definition with matching rid
     */
    public ProductDefinition getProduct(String id){
        //
        String sql =
                "SELECT * FROM product_definitions WHERE id=\"" + id +"\"";

        try(Connection con = sql2o.open()) {
            List<ProductDefinition> result = con.createQuery(sql).executeAndFetch(ProductDefinition.class);
            con.close();
            return result.get(0);
        }
    }

    public List<Component> getComponents(String product_id){

        String sql =
                "SELECT "+
                    "part.id, part.title, part.cost, part.info, component.quantity "+
                        "FROM "+
                        "part_definitions part INNER JOIN product_components component "+
                        "ON part.id = component.part_id " +
                        "WHERE component.product_id =\"" + product_id +"\"";
        try(Connection con = sql2o.open()) {
            List<Component> result = con.createQuery(sql).executeAndFetch(Component.class);
            con.close();
            return result;
        }
    }


    /**
     * Adds a product to the database, given a ProductDefinition object representing a product
     * @param p - ProductDefinition object representing the product to be added
     * @param componentInfo - HashMap object mapping children part IDs to their quantity in this product
     * @return true/false depending if the product was added
     */
    public boolean addProduct(ProductDefinition p, HashMap<String, Integer> componentInfo){
        //
        String productTransaction =
                "INSERT into product_definitions VALUES (" +
                        "\"" + p.getId() + "\", \"" + p.getTitle() +"\", " + Float.toString(p.getCost()) + ", \"" + p.getCategory() + "\", \"" + p.getInfo()+"\" )";
        System.out.println(productTransaction);

        try(Connection con = sql2o.open()) {
            //Inserts Product Definition
            con.createQuery(productTransaction).executeUpdate();
            //Fetch generated ID
            String product_id = p.getId();
            //Inserts Product Components
            for(String part_id: componentInfo.keySet()){
                String quantity = Integer.toString(componentInfo.get(part_id));
                String componentTransaction = "INSERT into product_components VALUES (\"" + part_id +"\", " + quantity + ", \"" + product_id+"\")";
                con.createQuery(componentTransaction).executeUpdate();
            }
            return true;
        }
    }

    //TODO: Delete corresponding components from component table
    /**
     * Deletes a product from the database, given the unique id of the product
     * @param id (id of product)
     * @return true/false depending if the product was deleted
     */
    public boolean deleteProduct(String id){
        //
        String deleteProduct =
                "DELETE FROM product_definitions WHERE id=\"" + id+"\"";
        String deleteComponents =
                "DELETE FROM product_components WHERE product_id=\"" + id+"\"";
        try(Connection con = sql2o.open()) {
            con.createQuery(deleteProduct).executeUpdate();
            con.createQuery(deleteComponents).executeUpdate();
            return true;
        }
    }

}
