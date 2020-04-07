package assembly;

import database.Database;
import database.sql2o.Component;
import database.sql2o.InDevProduct;
import database.sql2o.WorkOrder;

import java.util.ArrayList;
import java.util.List;

public class AssemblyOperation implements Operation {

    private int totalParts;
    private ArrayList<String> partNames;
    private int currentStep;
    private String name;
    private Database db;
    private String workorder_id;

    /**
     *
     * @param o
     * @param p
     * @param db
     */
    public AssemblyOperation(WorkOrder o, InDevProduct p, Database db){
        List<Component> componentList = db.getProductDefinitionsTable().getComponents(p.getProduct_id());
        this.totalParts = 0;
        this.workorder_id = o.getId();
        this.partNames = new ArrayList<>();
        for(Component c: componentList){
            totalParts += c.getQuantity();
            for(int i = 0; i<c.getQuantity();i++){
                partNames.add(c.getTitle());
            }
        }
        this.currentStep = 0;
        this.name = db.getProductDefinitionsTable().getProduct(p.getProduct_id()).getTitle();
        this.db=db;
    }

    public boolean cycle(){
        if(currentStep==0){
            System.out.println("[AssemblyLine]: Started assembling " + name);
        }
        if(currentStep<totalParts){
            System.out.println("[AssemblyLine@"+name+"]: Adding a " + partNames.get(currentStep));
            float progress = 100* ((float)currentStep/(float)totalParts);
            this.db.getWorkOrderTable().updateProgress(workorder_id, progress);
            currentStep++;
            return false;
        }
        else{
            System.out.println("[AssemblyLine]: Finished assembling " + name);
            this.db.getWorkOrderTable().updateProgress(workorder_id,100);
            return true;
        }
    }
}
