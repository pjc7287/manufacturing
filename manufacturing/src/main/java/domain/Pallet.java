package domain;

import java.util.ArrayList;

public class Pallet {

    private int id;
    private String warehouse_loc;

    public Pallet(int id, String warehouse_loc) {
        this.id = id;
        this.warehouse_loc = warehouse_loc;
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
}
