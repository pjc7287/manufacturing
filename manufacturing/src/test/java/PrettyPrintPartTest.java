import database.sql2o.PrettyPrintPart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrettyPrintPartTest {

    PrettyPrintPart part = new PrettyPrintPart("Part Y", "321456");

    @Test
    public void getTitle(){
        assertEquals("Part Y", part.getTitle());
    }

    @Test
    public void setTitle(){
        part.setTitle("Part Z");
        assertEquals("Part Z", part.getTitle());
    }

    @Test
    public void getSerial_num(){
        assertEquals("321456", part.getSerial_num());
    }

    @Test
    public void setSerial_num(){
        part.setSerial_num("789654");
        assertEquals("789654", part.getSerial_num());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Part Y");
        testList.add("321456");
        assertEquals(part.toList(), testList);
    }
}
