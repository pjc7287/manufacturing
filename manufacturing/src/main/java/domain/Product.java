package domain;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int prod_id;
    private int serial_num;
    private String warehouse_loc;
    private int container_id;
    private String type;
    private String desc;

    public Product(int prod_id, int serial_num, String warehouse_loc, int container_id, String type, String desc) {
        this.prod_id = prod_id;
        this.serial_num = serial_num;
        this.warehouse_loc = warehouse_loc;
        this.container_id = container_id;
        this.type = type;
        this.desc = desc;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

    public String getWarehouse_loc() {
        return warehouse_loc;
    }

    public void setWarehouse_loc(String warehouse_loc) {
        this.warehouse_loc = warehouse_loc;
    }

    public int getContainer_id() {
        return container_id;
    }

    public void setContainer_id(int container_id) {
        this.container_id = container_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc(){ return desc; }

    public void setDesc(String desc) { this.desc = desc; }

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(Integer.toString(prod_id));
        list.add(Integer.toString(serial_num));
        list.add(warehouse_loc);
        list.add(Integer.toString(container_id));
        list.add(type);
        list.add(desc);
        return list;
    }
}

