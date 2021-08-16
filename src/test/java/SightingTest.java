import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingTest {
    @Test
    public void sighting_instantiatesCorrectly_true(){
        Sighting animalSighting = new Sighting("Becky", 1);
        assertTrue(animalSighting instanceof Sighting);
    }

    @Test
    public void name_getSName_true() {
        Sighting animalSighting = new Sighting("Becky", 1);
        assertEquals("Becky", animalSighting.getName());
    }

    @Test
    public void animal_getsAnimalId() {
        Sighting animalSighting = new Sighting("Becky", 1);
        assertEquals(1, animalSighting.getId());
    }

    @Test
    public void equals_nameAndAnimalIdAreEqual() {
        Sighting animalSighting = new Sighting("Becky", 1);
        Sighting animalSightingTwo = new Sighting("Becky", 1);
        assertTrue(animalSighting.equals(animalSightingTwo));
    }


}
