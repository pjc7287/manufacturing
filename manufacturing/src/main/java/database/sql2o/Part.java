package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class Part {

    private String part_id;
    private String serial_num;

    public Part(String part_id, String serial_num) {
        this.part_id = part_id;
        this.serial_num = serial_num;
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

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(part_id);
        list.add(serial_num);
        return list;
    }
}

