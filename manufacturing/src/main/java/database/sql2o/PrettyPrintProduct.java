package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class PrettyPrintProduct {

    private String title;
    private String product_id;
    private String serial_num;

    public PrettyPrintProduct(String title, String product_id, String serial_num){
        this.title = title;
        this.product_id = product_id;
        this.serial_num = serial_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<String> toList(){
        List<String> list = new ArrayList<>();
        list.add(title);
        list.add(product_id);
        list.add(serial_num);
        return list;
    }
}
