package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class WorkOrder {

    private int id;
    private String command;
    private int quantity;
    private String warehouse_loc;
    private int product_id;
    private String info;


    public WorkOrder(int id, String command, int quantity, String warehouse_loc, int product_id, String info) {
        this.id = id;
        this.command = command;
        this.quantity = quantity;
        this.warehouse_loc = warehouse_loc;
        this.product_id = product_id;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getWarehouse_loc() {
        return warehouse_loc;
    }

    public void setWarehouse_loc(String warehouse_loc) {
        this.warehouse_loc = warehouse_loc;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
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
        list.add(Integer.toString(id));
        list.add(command);
        list.add(Integer.toString(quantity));
        list.add(warehouse_loc);
        list.add(Integer.toString(product_id));
        list.add(info);
        return list;
    }


}
