package data;

import domain.WorkOrder;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class WorkOrderTable {

    private Sql2o sql2o;

    public WorkOrderTable(Sql2o sql2o) { this.sql2o = sql2o; }

    public List<WorkOrder> getAllWorkOrders(){
        String sql =
                "SELECT id, action, prod_id, desc" +
                        "FROM workorder";
        try(Connection con = sql2o.open()){
            List<WorkOrder> result = con.createQuery(sql).executeAndFetch(WorkOrder.class);
            con.close();
            return result;
        }
    }

    public boolean addWorkOrder(WorkOrder workOrder){
        String sql =
                "INSERT into workorder VALUES (" +
                        Integer.toString(workOrder.getId())+ ", \"" + workOrder.getAction() +"\", " + Integer.toString(workOrder.getProd_id()) + ", \"" + workOrder.getDesc() + ")";

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