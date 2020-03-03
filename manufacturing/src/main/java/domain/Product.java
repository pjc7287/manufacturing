package domain;

public class Product {

    private String prod_id;
    private int serial_num;
    private String warehuse_loc;
    private int container_id;
    private String condition_code;
    private String desc;

    public Product(String prod_id, int serial_num, String warehuse_loc, int container_id, String condition_code, String desc) {
        this.prod_id = prod_id;
        this.serial_num = serial_num;
        this.warehuse_loc = warehuse_loc;
        this.container_id = container_id;
        this.condition_code = condition_code;
        this.desc = desc;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

    public String getWarehuse_loc() {
        return warehuse_loc;
    }

    public void setWarehuse_loc(String warehuse_loc) {
        this.warehuse_loc = warehuse_loc;
    }

    public int getContainer_id() {
        return container_id;
    }

    public void setContainer_id(int container_id) {
        this.container_id = container_id;
    }

    public String getCondition_code() {
        return condition_code;
    }

    public void setCondition_code(String condition_code) {
        this.condition_code = condition_code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
