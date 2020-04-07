package database;

import database.sql2o.InDevProduct;
import database.sql2o.WorkOrder;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class InDevProductsTable {

    private Sql2o sql2o;

    public InDevProductsTable(Sql2o sql2o) { this.sql2o = sql2o; }

    public InDevProduct getProduct(String id){
        String sql =
                "SELECT * FROM indev_products WHERE serial_num = \"" + id + "\"";
        try(Connection con = sql2o.open()){
            List<InDevProduct> result = con.createQuery(sql).executeAndFetch(InDevProduct.class);
            con.close();
            return result.get(0);
        }
    }

    public boolean addNewProduct(InDevProduct p){
        String sql =
                "INSERT into indev_products VALUES (" +
                        "\""+p.getProduct_id()+"\", \"" + p.getSerial_num() +"\", \""+p.getWarehouse_loc()+"\")";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added new product to development");
            return true;
        }
    }


    public boolean removeProduct(String id){
        String sql =
                "DELETE FROM indev_products WHERE serial_num=\"" + id+"\"";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            return true;
        }
    }

}