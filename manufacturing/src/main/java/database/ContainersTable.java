package database;

import database.sql2o.Container;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class ContainersTable {

    private Sql2o sql2o;

    public ContainersTable(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    /**
     * Gets all of the Containers from the database and populates a list with container objects
     *
     * @return List<Container> list - List of Container objects representing the table
     */
    public List<Container> getAllContainers() {
        //
        String sql =
                "SELECT id, warehouse_loc, pallet_id FROM container";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Container.class);
        }
    }

/**
 //TODO: Update SQL statement to be a valid INSERT statement that amtches the given catalog
 //
     public boolean addPart(Part part){
         String sql =
         "SELECT id, description, duedate " +
            "FROM tasks";

         try(Connection con = sql2o.open()) {
            return con.createQuery(sql).executeUpdate();
         }
     }

 //TODO: Update SQL statement to be a valid DELETE statement that amtches the given catalog
 //
     public boolean deletePart(Part part){
        String sql =
        "SELECT id, description, duedate " +
            "FROM tasks";

        try(Connection con = sql2o.open()) {
          return con.createQuery(sql).executeUpdate();
        }
     }
 */
}

