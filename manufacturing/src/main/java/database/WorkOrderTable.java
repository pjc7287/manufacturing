package database;

import database.sql2o.WorkOrder;
import org.sql2o.Connection;

import java.util.List;

public class WorkOrderTable {

    private Connection connection;

    public WorkOrderTable(Connection connection) { this.connection = connection; }

    public List<WorkOrder> getAllWorkOrders(){
        String sql =
                "SELECT * FROM workorder";
        List<WorkOrder> result = connection.createQuery(sql).executeAndFetch(WorkOrder.class);
        return result;
    }

    public WorkOrder getWorkOrder(String id){
        String sql =
                "SELECT * FROM workorder where id =\"" + id + "\"";
        List<WorkOrder> result = connection.createQuery(sql).executeAndFetch(WorkOrder.class);
        return result.get(0);
    }

    public boolean addWorkOrder(WorkOrder wo){
        String sql =
                "INSERT into workorder  VALUES (" +
        "\""+wo.getId()+"\", \""+wo.getCommand()+"\", "+Float.toString(wo.getProgress())+", \""+wo.getWarehouse_loc()+"\", \""+wo.getProduct_id()+"\", \""+wo.getInfo()+"\")";

        connection.createQuery(sql).executeUpdate();
        return true;
    }

    public boolean deleteWorkOrder(String id){
        String sql =
                "DELETE FROM workorder WHERE id=\"" + id + "\"";
        connection.createQuery(sql).executeUpdate();
        return true;
    }

    public boolean updateProgress(String id, float progress){
        String sql =
                "UPDATE workorder SET progress = "+ Float.toString(progress) + " WHERE id = \"" + id + "\"";
        connection.createQuery(sql).executeUpdate();
        return true;
    }

}