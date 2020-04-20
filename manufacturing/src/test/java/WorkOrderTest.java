import database.sql2o.WorkOrder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WorkOrderTest {

    WorkOrder order = new WorkOrder("001", "fix", 0.0f, "Rochester", "0101", "This is info.");

    @Test
    public void testGetProduct_id(){
        assertEquals("0101", order.getProduct_id());
    }

    @Test
    public void testSetProd_id(){
        order.setProduct_id("1234");
        assertEquals("1234", order.getProduct_id());
    }

    @Test
    public void testGet_id(){
        assertEquals("001", order.getId());
    }

    @Test
    public void testSet_id(){
        order.setId("321");
        assertEquals("321", order.getId());
    }

    @Test
    public void testGetCommand(){
        assertEquals("fix", order.getCommand());
    }

    @Test
    public void testSetCommand(){
        order.setCommand("assemble");
        assertEquals("assemble", order.getCommand());
    }

    @Test
    public void testGetWarehouse_loc(){
        assertEquals("Rochester", order.getWarehouse_loc());
    }

    @Test
    public void testSetWarehouse_loc(){
        order.setWarehouse_loc("New York City");
        assertEquals("New York City", order.getWarehouse_loc());
    }

    @Test
    public void testGetProgress(){
        assertEquals(0.0f, order.getProgress());
    }

    @Test
    public void testSetProgress(){
        order.setProgress(99.9f);
        assertEquals(99.9f, order.getProgress());
    }

    @Test
    public void testGetInfo(){
        assertEquals("This is info.", order.getInfo());
    }

    @Test
    public void testSetInfo(){
        order.setInfo("This is test info. Maybe.");
        assertEquals("This is test info. Maybe.", order.getInfo());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("001");
        testList.add("fix");
        testList.add("0.0");
        testList.add("Rochester");
        testList.add("0101");
        testList.add("This is info.");
        assertEquals(order.toList(), testList);
    }
}
