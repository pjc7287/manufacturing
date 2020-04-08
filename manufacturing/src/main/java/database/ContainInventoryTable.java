package database;

import database.sql2o.Container;
import database.sql2o.Product;
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

    public Container findMatchingContainer(Product p){
        //First looks for a box with the same product in it, going to the same place
        String sql =
                "SELECT "+
                        "container.serial_num, container.warehouse_loc, container.pallet_id "+
                        "FROM "+
                        "container_inventory container INNER JOIN product_inventory product "+
                        "ON container.serial_num = product.container_id " +
                        "WHERE container.warehouse_loc =\"" + p.getWarehouse_loc() +"\"";
        List<Container> matching = connection.createQuery(sql).executeAndFetch(Container.class);
        if(matching.size()>0){
            return matching.get(0);
        }
        else{
            //Looks for any empty boxes going to the same place
            String sql2 = "SELECT c.* FROM container_inventory AS c "+
            "LEFT JOIN product_inventory AS p ON "+
            "p.container_id=c.serial_num "+
            "WHERE p.container_id IS NULL "+
            "AND c.warehouse_loc = \""+ p.getWarehouse_loc() + "\"";
            matching = connection.createQuery(sql2).executeAndFetch(Container.class);
            if(matching.size()>0){
                return matching.get(0);
            }
            else{
                return null;
            }
        }
    }

    public Container getContainer(String container_id){
        String sql = "SELECT * FROM container_inventory where serial_num=\""+container_id+"\"";
        return connection.createQuery(sql).executeAndFetch(Container.class).get(0);
    }

}

