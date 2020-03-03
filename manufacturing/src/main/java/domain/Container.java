package domain;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private int id;
    private String warehouse_loc;
    private int pallet_id;

    public Container(int id, String warehouse_loc, int pallet_id) {
        this.id = id;
        this.warehouse_loc = warehouse_loc;
        this.pallet_id = pallet_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarehouse_loc() {
        return warehouse_loc;
    }

    public void setWarehouse_loc(String warehouse_loc) {
        this.warehouse_loc = warehouse_loc;
    }

    public int getPallet_id() {
        return pallet_id;
    }

    public void setPallet_id(int pallet_id) {
        this.pallet_id = pallet_id;
    }

    public List toList(){
        ArrayList<String> list = new ArrayList<>();
        list.add(Integer.toString(id));
        list.add(warehouse_loc);
        list.add(Integer.toString(pallet_id));
        return list;
    }
}

