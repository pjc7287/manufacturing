package domain;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {

    private int part_id;
    private int recipe_id;
    private String name;
    private int quantity;
    private String desc;

    public Ingredient(int part_id, int recipe_id, String name, int quantity, String desc) {
        this.part_id = part_id;
        this.recipe_id = recipe_id;
        this.name = name;
        this.quantity = quantity;
        this.desc = desc;
    }

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> toList(){
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add(Integer.toString(part_id));
        tokens.add(Integer.toString(recipe_id));
        tokens.add(name);
        tokens.add(Integer.toString(quantity));
        tokens.add(desc);
        return tokens;
    }
}
