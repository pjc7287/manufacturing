package database;

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
}



