import database.sql2o.PartDefinition;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartDefinitionTest {

    PartDefinition partDefinition = new PartDefinition("001", "PartDef", 2.00f, "Part");

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
        assertEquals("PartDef", partDefinition.getTitle());
    }

    @Test
    public void testGetCost() {
        assertEquals(2.00f, partDefinition.getCost());
    }

    @Test
    public void testSetCost() {
        partDefinition.setCost(3.00f);
        assertEquals(3.00f, partDefinition.getCost());
    }

    @Test
    public void testSetTitle() {
        partDefinition.setTitle("Title");
        assertEquals("Title", partDefinition.getTitle());
    }

    @Test
    public void testGetInfo() {
        assertEquals("Part", partDefinition.getInfo());
    }

    @Test
    public void testSetInfo() {
        partDefinition.setInfo("Info");
        assertEquals("Info", partDefinition.getInfo());
    }

    @Test
    public void testToList(){
        ArrayList<String> testList = new ArrayList<>();
        testList.add("001");
        testList.add("PartDef");
        testList.add("2.0");
        testList.add("Part");
        assertEquals(partDefinition.toList(), testList);
    }

}
