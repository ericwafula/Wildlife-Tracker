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
}
