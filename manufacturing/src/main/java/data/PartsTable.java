package data;

import domain.Pallet;
import domain.Part;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class PartsTable {


    private Sql2o sql2o;

    public PartsTable(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    /**
     * Gets all of the parts from the database and populates a list with part objects
     * @return List<Part> list - List of Part objects representing the table
     */
    public List<Part> getAllParts(){
        //
        String sql =
                "SELECT part_id, serial_num, warehouse_loc, container_id, defective, \'desc\'" +
                        "FROM part";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Part.class);
        }
    }
    public List<Part> getPart(int pid){
        //
        String sql =
                "SELECT * FROM part WHERE part_id=" + Integer.toString(pid);

        try(Connection con = sql2o.open()) {
            List<Part> result = con.createQuery(sql).executeAndFetch(Part.class);
            con.close();
            return result;
        }
    }

    public boolean updatePartContainer(String serial_num, String container_id){
        //
        String sql =
                "UPDATE part SET container_id = " + container_id + " WHERE serial_num = " + serial_num ;

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Updated Part");
            return true;
        }
    }

    public boolean addPart(Part part){
        //
        String sql =
                "INSERT into part VALUES (" +
                        Integer.toString(part.getPart_id())+ ", \"" + part.getSerial_num() +"\", " + part.getWarehouse_loc() +"\", "+ Integer.toString(part.getContainer_id()) +"\", "+ part.isDefective() +"\", "+ part.isDefective() + "\" )";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added Part");
            return true;
        }
    }

    public boolean deletePart(int id){
        //
        String sql =
                "DELETE FROM part WHERE part_id=" + Integer.toString(id);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Deleted Part");
            return true;
        }
    }
}

