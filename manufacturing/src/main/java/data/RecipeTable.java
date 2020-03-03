package data;

import domain.Recipe;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

/**
 * Data Access Object (DAO) used to access the Recipe table
 */
public class RecipeTable {


    private Sql2o sql2o;

    public RecipeTable(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    /**
     * Gets all of the recipes from the database and populates a list with Recipe objects
     * @return List<Recipe> list - List of Recipe objects representing the table
     */
    public List<Recipe> getAllRecipes(){
        //
        String sql =
                "SELECT id, name, prod_id, `desc` " +
                        "FROM recipe";

        try(Connection con = sql2o.open()) {
            List<Recipe> result = con.createQuery(sql).executeAndFetch(Recipe.class);
            con.close();
            return result;
        }
    }

    /**
     * Gets all of the recipes from the database and populates a list with Recipe objects
     * @return List<Recipe> list - List of Recipe objects representing the table
     */
    public List<Recipe> getRecipe(int rid){
        //
        String sql =
                "SELECT * FROM recipe WHERE id=" + Integer.toString(rid);

        try(Connection con = sql2o.open()) {
            List<Recipe> result = con.createQuery(sql).executeAndFetch(Recipe.class);
            con.close();
            return result;
        }
    }


    /**
     * Adds a recipe to the database, given a Recipe object representing a recipe
     * @param recipe - Recipe object representing the recipe to be added
     * @return true/false depending if the recipe was added
     */
    public boolean addRecipe(Recipe recipe){
        //
        String sql =
                "INSERT into recipe VALUES (" +
                        Integer.toString(recipe.getId())+ ", \"" + recipe.getName() +"\", " + Integer.toString(recipe.getProd_id()) +", \"" + recipe.getDesc()+"\" )";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added recipe");
            return true;
        }
    }

    //TODO: Delete corresponding ingredients from ingredient table

    /**
     * Deletes a recipe from the database, given the unique id of the recipe
     * @param id (id of recipe)
     * @return true/false depending if the recipe was deleted
     */
    public boolean deleteRecipe(int id){
        //
        String sql =
                "DELETE FROM recipe WHERE id=" + Integer.toString(id);
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            return true;
        }
    }

}
