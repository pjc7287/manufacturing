package database;

import database.sql2o.Product;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class ProductTable {


    private Sql2o sql2o;

    public ProductTable(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    //TODO: Update SQL statement to match table params
    public List<Product> getAllProducts(){
        //
        String sql =
                "SELECT prod_id, serial_num, warehouse_loc, container_id, type, \'desc\'" +
                        "FROM product";
        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Product.class);
        }
    }
/**
    //TODO: Update SQL statement to be a valid INSERT statement that amtches the given catalog
    public boolean addProduct(Product product){
        //
        String sql =
                "SELECT id, description, duedate " +
                        "FROM tasks";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeUpdate();
        }
    }

    //TODO: Update SQL statement to be a valid DELETE statement that amtches the given catalog
    public boolean deleteProduct(Product product){
        //
        String sql =
                "SELECT id, description, duedate " +
                        "FROM tasks";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeUpdate();
        }
    }
 */
}

