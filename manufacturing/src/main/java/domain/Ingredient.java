package domain;

public class Ingredient {

    private int part_id;
    private int recipe_id;
    private String name;
    private int quantity;

    public Ingredient(int part_id, int recipe_id, String name, int quantity) {
        this.part_id = part_id;
        this.recipe_id = recipe_id;
        this.name = name;
        this.quantity = quantity;
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
}
