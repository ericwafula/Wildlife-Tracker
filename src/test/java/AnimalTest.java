import org.junit.Rule;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animals_instantiatesCorrectly_true(){
        Animal lucky = new Animal("Lucky");
        assertTrue(lucky instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_string() {
        Animal lucky = new Animal("Lucky");
        lucky.getName();
        assertEquals("Lucky", lucky.getName());
    }

    @Test
    public void equals_returnsTrueIfNameAndIdAreEqual() {
        Animal lucky = new Animal("Lucky");
        Animal becky = new Animal("Lucky");
        assertTrue(lucky.equals(becky));
    }

    @Test
    public void save_insertsObjectIntoDatabase_Animal() {
        Animal lucky = new Animal("Lucky");
        lucky.save();
        assertTrue(Animal.all().get(0).equals(lucky));
    }

    @Test
    public void all_returnsAllInstancesOfAnimal_true(){
        Animal lucky = new Animal("Lucky");
        lucky.save();
        Animal becky = new Animal("Becky");
        becky.save();
        Animal bucky = new Animal("Bucky");
        bucky.save();
        assertTrue(Animal.all().get(0).equals(lucky));
        assertTrue(Animal.all().get(1).equals(becky));
        assertTrue(Animal.all().get(2).equals(bucky));
    }

    @Test
    public void save_assignsIdToObject(){
        Animal unsavedLucky = new Animal("Lucky");
        unsavedLucky.save();
        Animal savedLucky = Animal.all().get(0);
        assertEquals(unsavedLucky.getId(), savedLucky.getId());
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        Animal lucky = new Animal("Lucky");
        lucky.save();
        Animal becky = new Animal("Becky");
        becky.save();
        assertEquals(Animal.find(becky.getId()), becky);
    }

    @Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        Animal lucky = new Animal("Lucky");
        lucky.save();
        Sighting nairobi = new Sighting(lucky.getId(), "Nairobi", "Becky");
        nairobi.save();
        Sighting kisumu = new Sighting(lucky.getId(), "Kisumu", "Bucky");
        kisumu.save();
        Sighting[] sightings = {nairobi, kisumu};
        assertTrue(lucky.getSightings().containsAll(Arrays.asList(sightings)));
    }
}
