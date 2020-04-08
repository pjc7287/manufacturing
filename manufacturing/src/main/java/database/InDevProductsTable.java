package database;

import database.sql2o.InDevProduct;
import org.sql2o.Connection;

import java.util.List;

public class InDevProductsTable {

    private Connection connection;

    public InDevProductsTable(Connection connection) { this.connection = connection; }

    public InDevProduct getProduct(String id){
        String sql =
                "SELECT * FROM indev_products WHERE serial_num = \"" + id + "\"";
        List<InDevProduct> result = connection.createQuery(sql).executeAndFetch(InDevProduct.class);
        connection.close();
        return result.get(0);
    }

    public boolean addNewProduct(InDevProduct p){
        String sql =
                "INSERT into indev_products VALUES (" +
                        "\""+p.getProduct_id()+"\", \"" + p.getSerial_num() +"\", \""+p.getWarehouse_loc()+"\")";

        connection.createQuery(sql).executeUpdate();
        return true;
    }


    public boolean removeProduct(String id){
        String sql =
                "DELETE FROM indev_products WHERE serial_num=\"" + id+"\"";
        connection.createQuery(sql).executeUpdate();
        return true;
    }

}