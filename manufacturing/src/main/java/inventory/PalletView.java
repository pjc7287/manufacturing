package inventory;

import java.util.ArrayList;
import java.util.List;

public class PalletView {

    private String id;
    private String location;
    private int numberOfItems;
    private String product_id;

    private List<BoxView> boxes;

    public PalletView(String id, String location){
        this.id = id;
        this.location = location;
        this.numberOfItems=0;
        this.boxes = new ArrayList<>();
        this.product_id = null;
    }

    public void addBox(BoxView box){
        boxes.add(box);
        this.numberOfItems+=box.getNumberOfItems();
    }

    public List<BoxView> getBoxes(){
        return this.boxes;
    }

    public String getId(){
        return this.id;
    }

    public String getLocation(){
        return this.location;
    }

    public int getNumberOfItems(){
        return this.numberOfItems;
    }

    public void setProduct_id(String product_id){
        this.product_id=product_id;
    }
}
