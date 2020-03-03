package data;

import domain.Pallet;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class PalletTable {

    private Sql2o sql2o;

    public PalletTable(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    /**
     * Gets all of the pallets from the database and populates a list with pallet objects
     * @return List<Pallet> list - List of Pallet objects representing the table
     */
    public List<Pallet> getAllPallets(){
        //
        String sql =
                "SELECT id, warehouse_loc FROM pallet";

        try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Pallet.class);
        }
    }

/**
     //TODO: Update SQL statement to be a valid INSERT statement that amtches the given recipe
     public boolean addPart(Part part){
     //
         String sql =
         "SELECT id, description, duedate " +
            "FROM tasks";

            try(Connection con = sql2o.open()) {
                return con.createQuery(sql).executeUpdate();
            }
     }

     //TODO: Update SQL statement to be a valid DELETE statement that amtches the given recipe
     public boolean deletePart(Part part){
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
