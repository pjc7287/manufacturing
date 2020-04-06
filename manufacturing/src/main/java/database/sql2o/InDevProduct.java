package database.sql2o;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * An InDevProduct is a Product that hasn't been assigned a container yet.
 */
public class InDevProduct {

    private int product_id;
    private String serial_num;
    private String warehouse_loc;


    public InDevProduct(int product_id, String serial_num, String warehouse_loc) {
        this.product_id = product_id;
        this.serial_num = serial_num;
        this.warehouse_loc = warehouse_loc;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
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
        list.add(Integer.toString(product_id));
        list.add(serial_num);
        list.add(warehouse_loc);
        return list;
    }

}

