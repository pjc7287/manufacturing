package data;

import domain.Ingredient;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/**
 * Data Access Object (DAO) used to access the Ingredient table
 */
public class IngredientTable {


    private Sql2o sql2o;

    public IngredientTable(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    /**
     * Gets all of the ingredients in the recipe from the database and populates a list with Ingredient objects
     * @return List<Ingredient> list - List of Ingredient objects representing the matching parts
     */
    public List<Ingredient> getRecipeIngredients(int id){
        //
        String sql =
                "SELECT *" +
                        "FROM ingredient WHERE recipe_id ="+ Integer.toString(id);

        try(Connection con = sql2o.open()) {
            List<Ingredient> result = con.createQuery(sql).executeAndFetch(Ingredient.class);
            con.close();
            return result;
        }
    }

    /**
     * Adds a ingredient to the database, given a Ingredient object representing a ingredient
     * @param ingredient - Ingredient object representing the ingredient to be added
     * @return true/false depending if the ingredient was added
     */
    public boolean addIngredient(Ingredient ingredient){
        //
        String sql =
                "INSERT into ingredient VALUES (" +
                        Integer.toString(ingredient.getPart_id())+ ", " + Integer.toString(ingredient.getRecipe_id()) +", \"" + ingredient.getName() +"\", "+ Integer.toString(ingredient.getQuantity())
                            + ", \"" + ingredient.getDesc() +"\" )";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added ingredient");
            return true;
        }
    }

    //TODO: Delete corresponding ingredients from ingredient table

    /**
     * Deletes a recipe from the database, given the unique id of the recipe
     * @param id (id of recipe)
     * @return true/false depending if the recipe was deleted
     */
    public boolean deleteRecipeIngredients(int id){
        //
        String sql =
                "DELETE FROM ingredient WHERE recipe_id = " + Integer.toString(id);
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            return true;
        }
    }

}
