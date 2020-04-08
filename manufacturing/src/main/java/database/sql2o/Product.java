package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String product_id;
    private String serial_num;
    private String warehouse_loc;
    private String container_id;

    public Product(String product_id, String serial_num, String warehouse_loc, String container_id) {
        this.product_id = product_id;
        this.serial_num = serial_num;
        this.warehouse_loc = warehouse_loc;
        this.container_id = container_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
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

    public String getContainer_id() {
        return container_id;
    }

    public void setContainer_id(String container_id) {
        this.container_id = container_id;
    }


    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(product_id);
        list.add(serial_num);
        list.add(warehouse_loc);
        list.add(container_id);
        return list;
    }
}

