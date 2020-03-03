package domain;

public class Part {

    private int part_id;
    private int serial_num;
    private String warehouse_loc;
    private int container_id;
    private boolean defective;
    private String desc;

    public Part(int part_id, int serial_num, String warehouse_loc, int container_id, boolean defective, String desc) {
        this.part_id = part_id;
        this.serial_num = serial_num;
        this.warehouse_loc = warehouse_loc;
        this.container_id = container_id;
        this.defective = defective;
        this.desc = desc;
    }

    public int getPart_id() {
        return part_id;
    }

    public void setPart_id(int part_id) {
        this.part_id = part_id;
    }

    public int getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(int serial_num) {
        this.serial_num = serial_num;
    }

    public String getWarehouse_loc() {
        return warehouse_loc;
    }

    public void setWarehouse_loc(String warehouse_loc) {
        this.warehouse_loc = warehouse_loc;
    }

    public int getContainer_id() {
        return container_id;
    }

    public void setContainer_id(int container_id) {
        this.container_id = container_id;
    }

    public boolean isDefective() {
        return defective;
    }

    public void setDefective(boolean defective) {
        this.defective = defective;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
