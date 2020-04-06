package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class Component {

    private int id;
    private String title;
    private float cost;
    private String info;
    private int quantity;

    public Component(int id, String title, float cost, String info, int quantity) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.info = info;
        this.quantity = quantity;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> toList(){
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add(Integer.toString(id));
        tokens.add(title);
        tokens.add(Float.toString(cost));
        tokens.add(info);
        tokens.add(Integer.toString(quantity));

        return tokens;
    }
}
