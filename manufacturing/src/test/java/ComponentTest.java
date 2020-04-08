import database.sql2o.Component;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponentTest {

    Component component = new Component("001", "Component X", 1.00f, "This is info.", 10);

    @Test
    public void testGet_id(){
        assertEquals("001", component.getId());
    }

    @Test
    public void testSet_id(){
        component.setId("321");
        assertEquals("321", component.getId());
    }

    @Test
    public void testGetTitle(){
        assertEquals("Component X", component.getTitle());
    }

    @Test
    public void testSetTitle(){
        component.setTitle("321");
        assertEquals("321", component.getTitle());
    }

    @Test
    public void testGetCost(){
        assertEquals(1.00, component.getCost());
    }

    @Test
    public void testSetCost(){
        component.setCost(3.00f);
        assertEquals(3.00, component.getCost());
    }

    @Test
    public void testGetInfo(){
        assertEquals("This is info.", component.getInfo());
    }

    @Test
    public void testSetInfo(){
        component.setInfo("This is test info. Maybe.");
        assertEquals("This is test info. Maybe.", component.getInfo());
    }

    @Test
    public void testGetQuantity(){
        assertEquals(10, component.getQuantity());
    }

    @Test
    public void testSetQuantity(){
        component.setQuantity(20);
        assertEquals(20, component.getQuantity());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("001");
        testList.add("Component X");
        testList.add("1.0");
        testList.add("This is info.");
        testList.add("10");
        assertEquals(component.toList(), testList);
    }

}
