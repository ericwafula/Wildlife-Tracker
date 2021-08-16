import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SightingTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

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
        assertEquals(1, animalSighting.getAnimalId());
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

    @Test
    public void all_returnsAllInstancesOfSighting() {
        Sighting firstAnimalSighting = new Sighting(1, "Zone A", "Becky");
        firstAnimalSighting.save();
        Sighting secondAnimalSighting = new Sighting(2, "Zone B", "Becka");
        secondAnimalSighting.save();
        Sighting thirdAnimalSighting = new Sighting(3, "Zone C", "Becka");
        thirdAnimalSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstAnimalSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondAnimalSighting));
        assertEquals(true, Sighting.all().get(2).equals(thirdAnimalSighting));
    }

    @Test
    public void find_returnsSightingWithTheSameId() {
        Sighting firstAnimalSighting = new Sighting(1, "Zone A", "Becky");
        firstAnimalSighting.save();
        Sighting secondAnimalSighting = new Sighting(2, "Zone B", "Becka");
        secondAnimalSighting.save();
        assertEquals(Sighting.find(secondAnimalSighting.getId()), secondAnimalSighting);
    }

    @Test
    public void save_saveEndangeredIdIntoDatabase_true() {
        Animal becky = new Animal("Becky");
        becky.save();
        Sighting nairobi = new Sighting(becky.getId(), "Zone A", "Becky");
        nairobi.save();
        assertEquals(nairobi.getAnimalId(), becky.getId());
    }
}
