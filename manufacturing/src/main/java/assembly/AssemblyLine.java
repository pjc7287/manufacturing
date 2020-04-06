package assembly;

import database.sql2o.WorkOrder;

import java.util.Deque;

public class AssemblyLine{


    private Deque<WorkOrder> orders;
    private WorkOrder currentOrder;

    public AssemblyLine(){
        //TODO: Initialize workorder queue from database
    }

    public void addOrder(WorkOrder o){
            orders.add(o);
    }


    public void cycle(){
        if(currentOrder!=null){

        }
        else{
            System.out.println("Moving on to next order");
            currentOrder=orders.pop();
        }
    }


}
