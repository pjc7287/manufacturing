import database.sql2o.InDevProduct;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InDevProductTest {

    InDevProduct product = new InDevProduct("001", "456321", "Rochester");

    @Test
    public void testGetProduct_id(){
        assertEquals("001", product.getProduct_id());
    }

    @Test
    public void testSetProd_id(){
        product.setProduct_id("1234");
        assertEquals("1234", product.getProduct_id());
    }

    @Test
    public void testGetProductSerial_num(){
        assertEquals("456321", product.getSerial_num());
    }

    @Test
    public void testSetProdSerial_num(){
        product.setSerial_num("789123");
        assertEquals("789123", product.getSerial_num());
    }

    @Test
    public void testGetWarehouse_loc(){
        assertEquals("Rochester", product.getWarehouse_loc());
    }

    @Test
    public void testSetWarehouse_loc(){
        product.setWarehouse_loc("New York City");
        assertEquals("New York City", product.getWarehouse_loc());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("001");
        testList.add("456321");
        testList.add("Rochester");
        assertEquals(product.toList(), testList);
    }

}
