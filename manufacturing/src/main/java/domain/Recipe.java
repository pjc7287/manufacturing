package domain;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private int id;
    private String name;
    private int prod_id;

    public Recipe(int id, String name, int prod_id){
        this.id = id;
        this.name = name;
        this.prod_id = prod_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(Integer.toString(id));
        list.add(name);
        list.add(Integer.toString(prod_id));
        return list;
    }
}
