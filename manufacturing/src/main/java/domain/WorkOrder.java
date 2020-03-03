package domain;

import java.util.ArrayList;
import java.util.List;

public class WorkOrder {

    private int id;
    private String action;
    private int prod_id;
    private String desc;

    public WorkOrder(int id, String action, int prod_id, String desc){
        this.id = id;
        this.action = action;
        this.prod_id = prod_id;
        this.desc = desc;
    }

    public void setProd_id(int prod_id) { this.prod_id = prod_id; }

    public int getProd_id() { return prod_id; }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public void setAction(String action) { this.action = action; }

    public String getAction() { return action; }

    public void setDesc(String desc) { this.desc = desc; }

    public String getDesc() { return desc; }


}
