import database.sql2o.ProductDefinition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDefinitionTest {

    ProductDefinition partDefinition = new ProductDefinition("001", "Definition", 0.02f, "None", "Info");

    @Test
    public void testGetId() {
        assertEquals("001", partDefinition.getId());
    }

    @Test
    public void testSetId() {
        partDefinition.setId("1234");
        assertEquals("1234", partDefinition.getId());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Definition", partDefinition.getTitle());
    }

    @Test
    public void testGetCost() {
        assertEquals(0.02f, partDefinition.getCost());
    }

    @Test
    public void testSetCost() {
        partDefinition.setCost(0.03f);
        assertEquals(0.03f, partDefinition.getCost());
    }

    @Test
    public void testSetTitle() {
        partDefinition.setTitle("Definition2");
        assertEquals("Definition2", partDefinition.getTitle());
    }

    @Test
    public void testGetCategory() {
        assertEquals("None", partDefinition.getCategory());
    }

    @Test
    public void testSetCategory() {
        partDefinition.setCategory("Sport");
        assertEquals("Sport", partDefinition.getCategory());
    }

    @Test
    public void testGetInfo(){
        assertEquals("Info", partDefinition.getInfo());
    }

    @Test
    public void testSetInfo() {
        partDefinition.setInfo("Not Info");
        assertEquals("Not Info", partDefinition.getInfo());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("001");
        testList.add("Definition");
        testList.add("0.02");
        testList.add("None");
        testList.add("Info");
        assertEquals(partDefinition.toList(), testList);
    }

}
