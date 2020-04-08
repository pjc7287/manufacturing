import database.sql2o.Part;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartTest {

    Part part = new Part("001", "123");

    @Test
    public void testGetPart_id() {
        assertEquals("001", part.getPart_id());
    }

    @Test
    public void testSetPart_id() {
        part.setPart_id("1234");
        assertEquals("1234", part.getPart_id());
    }

    @Test
    public void testGetSerial_num() {
        assertEquals("123", part.getSerial_num());
    }

    @Test
    public void testSetSerial_num() {
        part.setSerial_num("1234");
        assertEquals("1234", part.getSerial_num());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("001");
        testList.add("123");
        assertEquals(part.toList(), testList);
    }
}
