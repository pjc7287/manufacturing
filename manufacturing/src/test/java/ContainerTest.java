import database.sql2o.Container;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerTest {

    Container container = new Container("123", "Rochester", "001");

    @Test
    public void testGetSerial_num() {
        assertEquals("123", container.getSerial_num());
    }

    @Test
    public void testSetSerial_num() {
        container.setSerial_num("1234");
        assertEquals("1234", container.getSerial_num());

    }

    @Test
    public void testGetWarehouse_loc() {
        assertEquals("Rochester", container.getWarehouse_loc());
    }

    @Test
    public void testSetWarehouse_loc() {
        container.setWarehouse_loc("NYC");
        assertEquals("NYC", container.getWarehouse_loc());
    }

    @Test
    public void testGetPallet_id() {
        assertEquals("001", container.getPallet_id());
    }

    @Test
    public void testSetPallet_id() {
        container.setPallet_id("1234");
        assertEquals("1234", container.getPallet_id());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("123");
        testList.add("Rochester");
        testList.add("001");
        assertEquals(container.toList(), testList);
    }

}
