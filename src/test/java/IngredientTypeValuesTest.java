import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeValuesTest {

    @Test
    public void testValues() {
        assertEquals(2, IngredientType.values().length);
    }
}
