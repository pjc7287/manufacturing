package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class PartDefinition {

    private int id;
    private String title;
    private float cost;
    private String info;


    public PartDefinition(int id, String title, float cost, String info){
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
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
        list.add(title);
        list.add(Float.toString(cost));
        list.add(info);
        return list;
    }
}
