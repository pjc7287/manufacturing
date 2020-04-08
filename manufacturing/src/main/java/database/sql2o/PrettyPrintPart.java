package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class PrettyPrintPart {

    private String title;
    private String serial_num;

    public PrettyPrintPart(String title, String serial_num){
        this.title = title;
        this.serial_num = serial_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        list.add(serial_num);
        return list;
    }
}
