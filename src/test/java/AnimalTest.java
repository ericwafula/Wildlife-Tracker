import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AnimalTest {
    @Test
    public void animals_instantiatesCorrectly_true(){
        Animal lucky = new Animal("Lucky", 1);
        assertTrue(lucky instanceof Animal);
    }


}
