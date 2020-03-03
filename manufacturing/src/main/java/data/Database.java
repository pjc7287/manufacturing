package data;

import domain.Recipe;
import domain.WorkOrder;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private static final String DATABASE_URL = "jdbc:mysql://database-2.cjh0gwusmpx7.us-east-1.rds.amazonaws.com:3306/pc1";
    private static final String DATABASE_USERNAME = "admin";
    private static final String DATABASE_PASSWORD = "manufacturing";

    private final Sql2o sql2o = new Sql2o(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

    private ProductTable productTable;
    private RecipeTable recipeTable;
    private PartsTable partsTable;
    private WorkOrderTable workOrderTable;
    private IngredientTable ingredientTable;


    public Database(){
        this.productTable = new ProductTable(sql2o);
        this.recipeTable = new RecipeTable(sql2o);
        this.partsTable = new PartsTable(sql2o);
        this.workOrderTable = new WorkOrderTable(sql2o);
        this.ingredientTable = new IngredientTable(sql2o);
    }

    public WorkOrderTable getWorkOrderTable() {
        return workOrderTable;
    }

    public PartsTable getPartsTable() {
        return partsTable;
    }

    public ProductTable getProductTable() {
        return productTable;
    }

    public RecipeTable getRecipeTable() {
        return recipeTable;
    }

    public IngredientTable getIngredientTable(){ return ingredientTable;}


    /**
    public static void main(String[] args){
        Database db = new Database();
        List<Recipe> recipes = db.getRecipeTable().getAllRecipes();
        for(Recipe r: recipes){
            System.out.println("Recipe Name: "+ r.getTitle());
        }
        Recipe newRecipe = new Recipe(5,"Beans!", 500);
        System.out.println("Adding new recipe: ");
        System.out.println(db.getRecipeTable().addRecipe(newRecipe));

        recipes = db.getRecipeTable().getAllRecipes();
        for(Recipe r: recipes){
            System.out.println("Recipe Name: "+ r.getTitle());
        }

        db.getRecipeTable().deleteRecipe(5);

        recipes = db.getRecipeTable().getAllRecipes();
        for(Recipe r: recipes){
            System.out.println("Recipe Name: "+ r.getTitle());
        }
    }
     */
}
