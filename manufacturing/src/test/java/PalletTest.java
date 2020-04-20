import database.sql2o.Pallet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PalletTest {

    Pallet pallet = new Pallet("123", "Rochester");

    @Test
    public void testGetSerial_num() {
        assertEquals("123", pallet.getSerial_num());

    }

    @Test
    public void testSetSerial_num() {
        pallet.setSerial_num("1234");
        assertEquals("1234", pallet.getSerial_num());
    }

    @Test
    public void testGetWarehouse_loc() {
        assertEquals("Rochester", pallet.getWarehouse_loc());

    }

    @Test
    public void testSetWarehouse_loc() {
        pallet.setWarehouse_loc("NYC");
        assertEquals("NYC", pallet.getWarehouse_loc());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("123");
        testList.add("Rochester");
        assertEquals(pallet.toList(), testList);
    }
}
