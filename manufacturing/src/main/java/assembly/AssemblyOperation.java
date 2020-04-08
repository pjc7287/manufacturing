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
    private ArrayList<String> partIds;
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
        this.partIds = new ArrayList<>();
        for(Component c: componentList){
            totalParts += c.getQuantity();
            for(int i = 0; i<c.getQuantity();i++){
                partNames.add(c.getTitle());
                partIds.add(c.getId());
            }
        }
        this.currentStep = 0;
        this.name = db.getProductDefinitionsTable().getProduct(p.getProduct_id()).getTitle();
        this.db=db;
    }

    public boolean cycle(){
        if(currentStep==0){
            AssemblyMessageBox.message = "Started assembling " + name;
        }
        if(currentStep<totalParts){
            AssemblyMessageBox.message ="["+name+"]: Adding a " + partNames.get(currentStep);
            if(db.getPartInventoryTable().consumePart(partIds.get(currentStep))) {
                float progress = 100 * ((float) currentStep / (float) totalParts);
                this.db.getWorkOrderTable().updateProgress(workorder_id, progress);
                currentStep++;
            }
            else{
                AssemblyMessageBox.message = "["+name+"]: Error! Requesting more "+ partNames.get(currentStep);
                //Stubbed out. This is where we would get more parts from Inventory team
                //
                //
                //
                //
            }
            return false;
        }
        else{
            AssemblyMessageBox.message ="[AssemblyLine]: Finished assembling " + name;
            this.db.getWorkOrderTable().updateProgress(workorder_id,100);
            return true;
        }
    }
}
