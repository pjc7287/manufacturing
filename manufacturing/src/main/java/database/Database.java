package database;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Database {


    private static final String DATABASE_URL = "jdbc:mysql://database-2.cjh0gwusmpx7.us-east-1.rds.amazonaws.com:3306/pc1?autoReconnect=true&useSSL=false";
    private static final String DATABASE_USERNAME = "admin";
    private static final String DATABASE_PASSWORD = "manufacturing";

    private final Sql2o sql2o = new Sql2o(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

    private ProductDefinitionsTable product_definitionsTable;
    private PartDefinitionsTable part_definitionsTable;
    private ProductInventoryTable product_inventoryTable;
    private PartsInventoryTable part_inventoryTable;
    private PalletInventoryTable pallet_inventoryTable;
    private ContainInventoryTable container_inventoryTable;
    private WorkOrderTable workorderTable;
    private InDevProductsTable indev_productsTable;

    private Connection connection;


    public Database(){

        this.connection = sql2o.open();

        this.product_inventoryTable = new ProductInventoryTable(connection);
        this.product_definitionsTable = new ProductDefinitionsTable(connection);
        this.part_definitionsTable = new PartDefinitionsTable(connection);
        this.part_inventoryTable = new PartsInventoryTable(connection);
        this.pallet_inventoryTable = new PalletInventoryTable(connection);
        this.container_inventoryTable = new ContainInventoryTable(connection);
        this.workorderTable = new WorkOrderTable(connection);
        this.indev_productsTable = new InDevProductsTable(connection);
    }

    public WorkOrderTable getWorkOrderTable() {
        return workorderTable;
    }

    public PartsInventoryTable getPartInventoryTable() {  return part_inventoryTable; }

    public ProductInventoryTable getProductInventoryTable() {
        return product_inventoryTable;
    }

    public ProductDefinitionsTable getProductDefinitionsTable() {
        return product_definitionsTable;
    }

    public PartDefinitionsTable getPartDefinitionsTable(){
        return part_definitionsTable;
    }

    public PalletInventoryTable getPalletInventoryTable() { return pallet_inventoryTable; }

    public ContainInventoryTable getContainerInventoryTable() { return container_inventoryTable; }

    public InDevProductsTable getInDevProductsTable(){return indev_productsTable;}

}

