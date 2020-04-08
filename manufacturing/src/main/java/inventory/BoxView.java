package inventory;

public class BoxView {

    private String id;
    private String type; //Holding either Part or Product
    private int numberOfItems; //Number of items

    public BoxView(String id, String type, int numberOfItems){
        this.id = id;
        this.type = type;
        this.numberOfItems = numberOfItems;
    }

    public int getnumberOfItems() {
        return this.numberOfItems;
    }

    public String getId(){
        return this.id;
    }

    public String getType(){
        return this.type;
    }
}
