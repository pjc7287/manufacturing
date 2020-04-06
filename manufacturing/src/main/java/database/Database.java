package database;

import org.sql2o.Sql2o;

public class Database {


    private static final String DATABASE_URL = "jdbc:mysql://database-2.cjh0gwusmpx7.us-east-1.rds.amazonaws.com:3306/pc1?autoReconnect=true&useSSL=false";
    private static final String DATABASE_USERNAME = "admin";
    private static final String DATABASE_PASSWORD = "manufacturing";

    private final Sql2o sql2o = new Sql2o(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

    private ProductDefinitionsTable product_definitionsTable;
    private PartDefinitionsTable part_definitionsTable;

    private ProductTable productTable;
    private PartsTable partsTable;
    private PalletTable palletsTable;
    private ContainersTable containersTable;
    private WorkOrderTable workOrderTable;
    private InDevProductsTable inDevProductsTable;


    public Database(){
        this.productTable = new ProductTable(sql2o);
        this.product_definitionsTable = new ProductDefinitionsTable(sql2o);
        this.part_definitionsTable = new PartDefinitionsTable(sql2o);
        this.partsTable = new PartsTable(sql2o);
        this.palletsTable = new PalletTable(sql2o);
        this.containersTable = new ContainersTable(sql2o);
        this.workOrderTable = new WorkOrderTable(sql2o);
        this.inDevProductsTable = new InDevProductsTable(sql2o);
    }

    public WorkOrderTable getWorkOrderTable() {
        return workOrderTable;
    }

    public PartsTable getPartsTable() {  return partsTable; }

    public ProductTable getProductTable() {
        return productTable;
    }

    public ProductDefinitionsTable getProductDefinitionsTable() {
        return product_definitionsTable;
    }

    public PartDefinitionsTable getPartDefinitionsTable(){
        return part_definitionsTable;
    }

    public PalletTable getPalletsTable() { return palletsTable; }

    public ContainersTable getContainersTable() { return containersTable; }

    public InDevProductsTable getInDevProductsTable(){return inDevProductsTable;}




    /**
    public static void main(String[] args){
        Database db = new Database();
        List<Recipe> catalog = db.getRecipeTable().getAllRecipes();
        for(Recipe r: catalog){
            System.out.println("Recipe Name: "+ r.getTitle());
        }
        Recipe newRecipe = new Recipe(5,"Beans!", 500);
        System.out.println("Adding new catalog: ");
        System.out.println(db.getRecipeTable().addRecipe(newRecipe));

        catalog = db.getRecipeTable().getAllRecipes();
        for(Recipe r: catalog){
            System.out.println("Recipe Name: "+ r.getTitle());
        }

        db.getRecipeTable().deleteRecipe(5);

        catalog = db.getRecipeTable().getAllRecipes();
        for(Recipe r: catalog){
            System.out.println("Recipe Name: "+ r.getTitle());
        }
    }
     */
}

