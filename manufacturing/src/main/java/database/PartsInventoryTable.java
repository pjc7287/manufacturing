package database;

import database.sql2o.Part;
import org.sql2o.Connection;

import java.util.List;

public class PartsInventoryTable {


    private Connection connection;

    public PartsInventoryTable(Connection connection) { this.connection = connection; }

    /**
     * Gets all of the parts from the database and populates a list with part objects
     * @return List<Part> list - List of Part objects representing the table
     */
    public List<Part> getAllParts(){
        //
        String sql =
                "SELECT * FROM part_inventory";

        return connection.createQuery(sql).executeAndFetch(Part.class);

    }

    public List<Part> getContainersParts(String container_id){
        String sql =
                "SELECT * FROM part_inventory where container_id = \"" + container_id + "\"";

        return connection.createQuery(sql).executeAndFetch(Part.class);
    }

    public synchronized boolean consumePart(String part_id){
        String sql =
                "SELECT * FROM part_inventory where part_id = \"" + part_id + "\"";
        List<Part> parts = connection.createQuery(sql).executeAndFetch(Part.class);
        if(parts.size()>0){
            //Part found in inventory. Remove one (pick first and remove it)
            Part partToRemove = parts.get(0);
            String del = "DELETE FROM part_inventory where serial_num = \"" + partToRemove.getSerial_num() + "\"";
            connection.createQuery(del).executeUpdate();
            return true;
        }
        else{
            return false;
        }
    }

}

