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
                "SELECT id, command, quantity, warehouse_loc, product_id, info " +
                        "FROM workorder";
        try(Connection con = sql2o.open()){
            List<WorkOrder> result = con.createQuery(sql).executeAndFetch(WorkOrder.class);
            con.close();
            return result;
        }
    }

    public boolean addWorkOrder(WorkOrder wo){
        String sql =
                "INSERT into workorder (command, quantity, warehouse_loc, product_id, info) VALUES (" +
        "\""+wo.getCommand()+"\", "+Integer.toString(wo.getQuantity())+", \""+wo.getWarehouse_loc()+"\", "+Integer.toString(wo.getProduct_id())+", \""+wo.getInfo()+"\")";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            System.out.println("Added work order");
            return true;
        }
    }

    public boolean deleteWorkOrder(int id){
        String sql =
                "DELETE FROM workorder WHERE id=" + Integer.toString(id);
        try(Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
            return true;
        }
    }
}