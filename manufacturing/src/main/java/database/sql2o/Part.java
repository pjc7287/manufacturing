package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class Part {

    private String part_id;
    private String serial_num;
    private String warehouse_loc;
    private String container_id;

    public Part(String part_id, String serial_num, String warehouse_loc, String container_id) {
        this.part_id = part_id;
        this.serial_num = serial_num;
        this.warehouse_loc = warehouse_loc;
        this.container_id = container_id;
    }

    public String getPart_id() {
        return part_id;
    }

    public void setPart_id(String part_id) {
        this.part_id = part_id;
    }

    public String getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
    }

    public String getWarehouse_loc() {
        return warehouse_loc;
    }

    public void setWarehouse_loc(String warehouse_loc) {
        this.warehouse_loc = warehouse_loc;
    }

    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }


    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(part_id);
        list.add(serial_num);
        list.add(warehouse_loc);
        list.add(container_id);
        return list;
    }
}

