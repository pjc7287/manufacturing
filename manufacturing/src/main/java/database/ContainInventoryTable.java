package database;

import database.sql2o.Container;
import org.sql2o.Connection;
import java.util.List;

public class ContainInventoryTable {

    private Connection connection;

    public ContainInventoryTable(Connection connection) {
        this.connection = connection;
    }

    /**
     * Gets all of the Containers from the database and populates a list with container objects
     *
     * @return List<Container> list - List of Container objects representing the table
     */
    public List<Container> getAllContainers() {
        //
        String sql =
                "SELECT * FROM container_inventory";

        return connection.createQuery(sql).executeAndFetch(Container.class);
    }

    public List<Container> getPalletsContainers(String pallet_id) {
        String sql =
                "SELECT * FROM container_inventory where pallet_id=\"" + pallet_id + "\"";
        return connection.createQuery(sql).executeAndFetch(Container.class);

    }

    public boolean addContainer(Container c){
        String sql = "INSERT INTO container_inventory VALUES (\""
                + c.getSerial_num() + "\", \"" + c.getWarehouse_loc() +"\", \"" + c.getPallet_id()+"\")";
        connection.createQuery(sql).executeUpdate();
        return true;
    }

}

