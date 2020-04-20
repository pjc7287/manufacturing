import database.sql2o.PrettyPrintProduct;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrettyPrintProductTest {

    PrettyPrintProduct product = new PrettyPrintProduct("Product Z", "001", "382910");

    @Test
    public void getTitle(){
        assertEquals("Product Z", product.getTitle());
    }

    @Test
    public void setTitle(){
        product.setTitle("Product A");
        assertEquals("Product A", product.getTitle());
    }

    @Test
    public void getProduct_id(){
        assertEquals("001", product.getProduct_id());
    }

    @Test
    public void setProduct_id(){
        product.setProduct_id("002");
        assertEquals("002", product.getProduct_id());
    }

    @Test
    public void getSerial_num(){
        assertEquals("382910", product.getSerial_num());
    }

    @Test
    public void setSerial_num(){
        product.setSerial_num("019283");
        assertEquals("019283", product.getSerial_num());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("Product Z");
        testList.add("001");
        testList.add("382910");
        assertEquals(product.toList(), testList);
    }

}
