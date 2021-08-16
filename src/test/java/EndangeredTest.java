import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class EndangeredTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangered_instantiatesWithName_true(){
        Endangered becky = new Endangered("Becky");
        assertEquals("Becky", becky.getName());
    }


    @Test
    public void equals_returnsIfNameAndAnimalIdAreTheSame_true(){
        Endangered becky = new Endangered("Becky");
        Endangered lucky = new Endangered("Becky");
        assertTrue(becky.equals(lucky));
    }

    @Test
    public void save_returnsTrueIfDescriptionsAreTheSame(){
        Endangered becky = new Endangered("Becky");
        becky.save();
        assertTrue(Endangered.all().get(0).equals(becky));
    }

    @Test
    public void save_assignsIdToMonster(){
        Endangered unsavedBecky = new Endangered("Becky");
        unsavedBecky.save();
        Endangered savedBecky = Endangered.find(unsavedBecky.getId());
        assertEquals(savedBecky.getId(), unsavedBecky.getId());
    }

    @Test
    public void getSightings_retrievesAllSightingsFromDatabase_sightingsList() {
        Endangered lucky = new Endangered("Lucky");
        lucky.save();
        Sighting nairobi = new Sighting(lucky.getId(), "Nairobi", "Becky");
        nairobi.save();
        Sighting kisumu = new Sighting(lucky.getId(), "Kisumu", "Bucky");
        kisumu.save();
        Sighting[] sightings = {nairobi, kisumu};
        assertTrue(lucky.getSightings().containsAll(Arrays.asList(sightings)));
    }
}
