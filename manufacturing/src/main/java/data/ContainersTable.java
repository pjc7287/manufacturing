package data;

import domain.Container;
import domain.Recipe;
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

    public List<Recipe> getContainer(int cid){
        //
        String sql =
                "SELECT * FROM container WHERE id=" + Integer.toString(cid);

        try(Connection con = sql2o.open()) {
            List<Recipe> result = con.createQuery(sql).executeAndFetch(Recipe.class);
            con.close();
            return result;
        }
    }

    public boolean updateContainerPallet(String cid, String pallet_id){
        //
        String sql =
                "UPDATE container SET container.pallet_id = '" + pallet_id + "' WHERE container.id = " + cid ;

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Updated Container");
            return true;
        }
    }

    public boolean addContainer(Container container){
        //
        String sql =
                "INSERT into container VALUES (" +
                        Integer.toString(container.getId())+ ", \"" + container.getWarehouse_loc() +"\", " + Integer.toString(container.getPallet_id()) + "\" )";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added Container");
            return true;
        }
    }

    public boolean deleteContainer(int id){
        //
        String sql =
                "DELETE FROM container WHERE id=" + Integer.toString(id);

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Deleted Container");
            return true;
        }
    }
}