import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void animals_instantiatesCorrectly_true(){
        Animal lucky = new Animal("Lucky", 1);
        assertTrue(lucky instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_string() {
        Animal lucky = new Animal("Lucky", 1);
        lucky.getName();
        assertEquals("Lucky", lucky.getName());
    }

    @Test
    public void getId_animalInstantiatesWithId_int() {
        Animal lucky = new Animal("Lucky", 1);
        lucky.getId();
        assertEquals(1, lucky.getId());
    }

    @Test
    public void equals_returnsTrueIfNameAndIdAreEqual() {
        Animal lucky = new Animal("Lucky", 1);
        Animal becky = new Animal("Lucky", 1);
        assertTrue(lucky.equals(becky));
    }
}
