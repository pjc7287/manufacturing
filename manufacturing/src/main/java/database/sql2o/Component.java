package database.sql2o;

import java.util.ArrayList;
import java.util.List;

public class Component {

    private String id;
    private String title;
    private float cost;
    private String info;
    private int quantity;

    public Component(String id, String title, float cost, String info, int quantity) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.info = info;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        tokens.add(id);
        tokens.add(title);
        tokens.add(Float.toString(cost));
        tokens.add(info);
        tokens.add(Integer.toString(quantity));

        return tokens;
    }
}
