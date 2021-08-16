import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingTest {
    @Test
    public void sighting_instantiatesCorrectly_true(){
        Sighting animalSighting = new Sighting(1, "Zone A", "Becky");
        assertTrue(animalSighting instanceof Sighting);
    }

    @Test
    public void name_getSName_true() {
        Sighting animalSighting = new Sighting(1, "Zone A", "Becky");
        assertEquals("Becky", animalSighting.getRangerName());
    }

    @Test
    public void animal_getsAnimalId() {
        Sighting animalSighting = new Sighting(1, "Zone A", "Becky");
        assertEquals(1, animalSighting.getId());
    }

    @Test
    public void equals_nameAndAnimalIdAreEqual() {
        Sighting animalSighting = new Sighting(1, "Zone A", "Becky");
        Sighting animalSightingTwo = new Sighting(1, "Zone A", "Becky");
        assertTrue(animalSighting.equals(animalSightingTwo));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame() {
        Sighting animalSighting = new Sighting(1, "Zone A", "Becky");
        animalSighting.save();
        assertTrue(Sighting.all().get(0).equals(animalSighting));
    }


}
