package routes.gson;

public class APIWorkOrder {

    private String product_id;
    private String warehouse_loc;
    private String command;
    private String info;

    public APIWorkOrder(String product_id, String warehouse_loc, String command, String info) {
        this.product_id = product_id;
        this.warehouse_loc = warehouse_loc;
        this.command = command;
        this.info = info;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getWarehouse_loc() {
        return warehouse_loc;
    }

    public void setWarehouse_loc(String warehouse_loc) {
        this.warehouse_loc = warehouse_loc;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
