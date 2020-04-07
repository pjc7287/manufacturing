package database;

import database.sql2o.WorkOrder;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class WorkOrderTable {

    private Sql2o sql2o;

    public WorkOrderTable(Sql2o sql2o) { this.sql2o = sql2o; }

    public List<WorkOrder> getAllWorkOrders(){
        String sql =
                "SELECT id, command, progress, warehouse_loc, product_id, info " +
                        "FROM workorder";
        try(Connection con = sql2o.open()){
            List<WorkOrder> result = con.createQuery(sql).executeAndFetch(WorkOrder.class);
            con.close();
            return result;
        }
    }

    public boolean addWorkOrder(WorkOrder wo){
        String sql =
                "INSERT into workorder  VALUES (" +
        "\""+wo.getId()+"\", \""+wo.getCommand()+"\", "+Float.toString(wo.getProgress())+", \""+wo.getWarehouse_loc()+"\", \""+wo.getProduct_id()+"\", \""+wo.getInfo()+"\")";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added work order");
            return true;
        }
    }

    public boolean deleteWorkOrder(String id){
        String sql =
                "DELETE FROM workorder WHERE id=\"" + id + "\"";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            return true;
        }
    }

    public boolean updateProgress(String id, float progress){
        String sql =
                "UPDATE workorder SET progress = "+ Float.toString(progress) + " WHERE id = \"" + id + "\"";
        try(Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
            return true;
        }
    }

}