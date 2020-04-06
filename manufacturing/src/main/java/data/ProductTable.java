package data;

import domain.Product;
import domain.Recipe;
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

    public List<Product> getProduct(int pid){
        //
        String sql =
                "SELECT * FROM product WHERE prod_id=" + Integer.toString(pid);

        try(Connection con = sql2o.open()) {
            List<Product> result = con.createQuery(sql).executeAndFetch(Product.class);
            con.close();
            return result;
        }
    }

    public boolean updateProductContainer(String serial_num, String container_id){
        //
        System.out.println("Here----------------------");
        String sql =
                "UPDATE product SET container_id = " + container_id + " WHERE serial_num = " + serial_num ;

        System.out.println(sql);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Updated Product");
            return true;
        }
    }

    public boolean addContainer(Product product){
        //
        String sql =
                "INSERT into product VALUES (" +
                        Integer.toString(product.getProd_id())+ ", " + Integer.toString(product.getSerial_num()) + ", \"" +  product.getWarehouse_loc() + "\", " + Integer.toString(product.getContainer_id()) + product.getType() + ", \"" + product.getDesc() + "\" )";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added Product");
            return true;
        }
    }

    public boolean deleteContainer(int id){
        //
        String sql =
                "DELETE FROM product WHERE prod_id=" + Integer.toString(id);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Deleted Product");
            return true;
        }
    }

}

