package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class Pallet {

    private String serial_num;
    private String warehouse_loc;

    public Pallet(String serial_num, String warehouse_loc) {
        this.serial_num = serial_num;
        this.warehouse_loc = warehouse_loc;
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

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(serial_num);
        list.add(warehouse_loc);
        return list;
    }
}

