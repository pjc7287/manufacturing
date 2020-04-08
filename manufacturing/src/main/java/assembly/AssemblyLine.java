package assembly;

import database.Database;
import database.InDevProductsTable;
import database.WorkOrderTable;
import database.sql2o.InDevProduct;
import database.sql2o.WorkOrder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class AssemblyLine{


    private Deque<Operation> orderQueue;
    private Operation currentOperation;
    private Database db;

    public AssemblyLine(Database db){
        this.db = db;
        this.orderQueue = new ArrayDeque<>();
        System.out.println("[AssemblyLine]: Turning On...");


        List<WorkOrder> workOrders = db.getWorkOrderTable().getAllWorkOrders();
        InDevProductsTable idpt = db.getInDevProductsTable();

        for(WorkOrder wo : workOrders){
            if(wo.getProgress()<100) {
                InDevProduct prod = idpt.getProduct(wo.getProduct_id());
                this.addOrder(wo, prod);
            }
        }

        this.cycle();
    }

    public void addOrder(WorkOrder o, InDevProduct p){
        switch(o.getCommand()){
            case("assemble"):
                Operation newOperation = new AssemblyOperation(o,p,db);
                orderQueue.add(newOperation);
                break;
            case("fix"):
                break;
            case("disassemble"):
                break;
            default:
                System.out.println("Error in assembly line: incorrect command inputted");
                break;
        }
    }

    public void cycle(){
        if(currentOperation==null){
            if(orderQueue.peek()!=null){
                currentOperation=orderQueue.pop();
            }
        }
        if(currentOperation!=null){
            if(currentOperation.cycle()){
                if(orderQueue.peek()!=null){
                    currentOperation=orderQueue.pop();
                }
                else{
                    currentOperation=null;
                }
            };
        }
        else{
            System.out.println("[AssemblyLine]: Waiting for orders...");
        }
    }


}
