package database;

import database.sql2o.PrettyPrintProduct;
import database.sql2o.Product;
import org.sql2o.Connection;

import java.util.List;

public class ProductInventoryTable {


    private Connection connection;

    public ProductInventoryTable(Connection connection) { this.connection = connection; }

    public List<Product> getAllProducts(){
        //
        String sql =
                "SELECT * FROM product_inventory";

        return connection.createQuery(sql).executeAndFetch(Product.class);
    }

    public List<PrettyPrintProduct> getContainersProducts(String container_id){
        String sql =
                "SELECT d.title, p.product_id, p.serial_num FROM " +
                        "product_inventory p INNER JOIN product_definitions d "+
                        "on p.product_id = d.id "+
                        "where container_id = \"" + container_id + "\"";

        return connection.createQuery(sql).executeAndFetch(PrettyPrintProduct.class);

    }

    public void addProduct(Product p){
        String sql =
                "INSERT INTO product_inventory VALUES (" +
                        "\"" + p.getProduct_id()+ "\", \"" + p.getSerial_num()+ "\", \"" + p.getWarehouse_loc()+ "\", \"" + p.getContainer_id() + "\")";
        connection.createQuery(sql).executeUpdate();
    }
}

