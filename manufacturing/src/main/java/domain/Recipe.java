package domain;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private int id;
    private String title;
    private int prod_id;

    public Recipe(int id, String title, int prod_id){
        this.id = id;
        this.title = title;
        this.prod_id = prod_id;
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

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(Integer.toString(id));
        list.add(title);
        list.add(Integer.toString(prod_id));
        return list;
    }
}
