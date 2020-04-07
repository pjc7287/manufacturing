package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class WorkOrder {

    private String id;
    private String command;
    private float progress;
    private String warehouse_loc;
    private String product_id;
    private String info;


    public WorkOrder(String id, String command, float progress, String warehouse_loc, String product_id, String info) {
        this.id = id;
        this.command = command;
        this.progress = progress;
        this.warehouse_loc = warehouse_loc;
        this.product_id = product_id;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    public String getWarehouse_loc() {
        return warehouse_loc;
    }

    public void setWarehouse_loc(String warehouse_loc) {
        this.warehouse_loc = warehouse_loc;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(id);
        list.add(command);
        list.add(Float.toString(progress));
        list.add(warehouse_loc);
        list.add(product_id);
        list.add(info);
        return list;
    }


}
