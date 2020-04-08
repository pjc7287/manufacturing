package database;

import database.sql2o.Container;
import database.sql2o.Pallet;
import org.sql2o.Connection;

import java.util.List;

public class PalletInventoryTable {

    private Connection connection;

    public PalletInventoryTable(Connection connection) { this.connection = connection; }

    /**
     * Gets all of the pallets from the database and populates a list with pallet objects
     * @return List<Pallet> list - List of Pallet objects representing the table
     */
    public List<Pallet> getAllPallets(){
        //
        String sql =
                "SELECT * FROM pallet_inventory";

        return connection.createQuery(sql).executeAndFetch(Pallet.class);
    }

    public boolean addPallet(Pallet pallet){
        String sql = "INSERT INTO pallet_inventory VALUES (\"" + pallet.getSerial_num() + "\", \"" + pallet.getWarehouse_loc() +"\")";
        connection.createQuery(sql).executeUpdate();
        return true;
    }

    public void shipPallet(String pallet_id){
        String sql = "SELECT * FROM container_inventory where pallet_id=\""+pallet_id+"\"";
        List<Container> childBoxes = connection.createQuery(sql).executeAndFetch(Container.class);
        for(Container box : childBoxes){
            String del = "DELETE FROM product_inventory where container_id=\""+box.getSerial_num()+"\"";
            connection.createQuery(del).executeUpdate();
            String delbox = "DELETE FROM container_inventory where serial_num=\""+box.getSerial_num()+"\"";
            connection.createQuery(delbox).executeUpdate();
        }
        String delpal = "DELETE FROM pallet_inventory where serial_num=\""+pallet_id+"\"";
        connection.createQuery(delpal).executeUpdate();
    }
}



