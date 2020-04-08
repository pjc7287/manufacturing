package database;

import database.sql2o.PartDefinition;
import org.sql2o.Connection;

import java.util.List;

/**
 * Data Access Object (DAO) used to access the part_definitions table
 */
public class PartDefinitionsTable {


    private Connection connection;

    public PartDefinitionsTable(Connection connection) { this.connection = connection; }

    /**
     * Gets all of the parts from the database and populates a list with PartDefinition objects
     * @return List<PartDefinition> list - List of PartDefinition objects representing the table
     */
    public List<PartDefinition> getAllParts(){
        //
        String sql =
                "SELECT id, title, cost, info " +
                        "FROM part_definitions";

        List<PartDefinition> result = connection.createQuery(sql).executeAndFetch(PartDefinition.class);
        connection.close();
        return result;
    }

    /**
     * Gets part definition based on id
     * @return PartDefinition part - the part definition with matching id
     */
    public PartDefinition getPart(int id){
        //
        String sql =
                "SELECT * FROM part_definitions WHERE id=" + Integer.toString(id);

        List<PartDefinition> result = connection.createQuery(sql).executeAndFetch(PartDefinition.class);
        connection.close();
        return result.get(0);
    }


    /**
     * Adds a part to the database, given a PartDefinition object representing a part
     * @param p - PartDefinition object representing the product to be added
     * @return true/false depending if the product was added
     */
    public boolean addPart(PartDefinition p){
        //
        String sql =
                "INSERT into part_definitions  VALUES (" +
                         "\"" + p.getId()+"\", \"" + p.getTitle() +"\", " + Float.toString(p.getCost()) +", \"" + p.getInfo()+"\" )";
        connection.createQuery(sql).executeUpdate();
        return true;

    }

    //TODO: Delete corresponding ingredients from ingredient table

    /**
     * Deletes a part from the database, given the unique id of the part
     * @param id (id of part)
     * @return true/false depending if the part was deleted
     */
    public boolean deletePart(String id){
        //
        String sql =
                "DELETE FROM part_definitions WHERE id=\"" + id + "\"";
        connection.createQuery(sql).executeUpdate();
        return true;
    }

}
