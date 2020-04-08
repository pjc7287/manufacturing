package database;

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

    public List<Product> getContainersProducts(String container_id){
        String sql =
                "SELECT * FROM product_inventory where container_id = \"" + container_id + "\"";

        return connection.createQuery(sql).executeAndFetch(Product.class);

    }

    public void addProduct(Product p){
        String sql =
                "INSERT INTO product_inventory VALUES (" +
                        "\"" + p.getProduct_id()+ "\", \"" + p.getSerial_num()+ "\", \"" + p.getWarehouse_loc()+ "\", \"" + p.getContainer_id() + "\")";
        connection.createQuery(sql).executeUpdate();
    }
}

