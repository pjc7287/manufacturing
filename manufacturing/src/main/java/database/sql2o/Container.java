package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private String serial_num;
    private String warehouse_loc;
    private String pallet_id;

    public Container(String serial_num, String warehouse_loc, String pallet_id) {
        this.serial_num = serial_num;
        this.warehouse_loc = warehouse_loc;
        this.pallet_id = pallet_id;
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

    public String getPallet_id() {
        return pallet_id;
    }

    public void setPallet_id(String pallet_id) {
        this.pallet_id = pallet_id;
    }

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(serial_num);
        list.add(warehouse_loc);
        list.add(pallet_id);
        return list;
    }
}

