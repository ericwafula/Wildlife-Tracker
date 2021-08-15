import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangered_instantiatesWithName_true(){
        Endangered becky = new Endangered("Becky", 1);
        assertEquals("Becky", becky.getName());
    }

    @Test
    public void Endangered_instantiatesWithAnimalId(){
        Endangered becky = new Endangered("Becky", 1);
        assertEquals(1, becky.getAnimalId());
    }
}
