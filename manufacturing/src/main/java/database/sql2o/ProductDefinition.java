package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class ProductDefinition {

    private int id;
    private String title;
    private float cost;
    private String category;
    private String info;


    public ProductDefinition(int id, String title, float cost, String category, String info){
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        list.add(category);
        list.add(info);
        return list;
    }
}
