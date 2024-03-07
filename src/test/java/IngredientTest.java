import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testFillingIngredient() {
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Lettuce", 1.0f);
        assertEquals(1.0f, filling.getPrice(), 0.001);
        assertEquals("Lettuce", filling.getName());
        assertEquals(IngredientType.FILLING, filling.getType());
    }

    @Test
    public void testSauceIngredient() {
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.5f);
        assertEquals(0.5f, sauce.getPrice(), 0.001);
        assertEquals("Ketchup", sauce.getName());
        assertEquals(IngredientType.SAUCE, sauce.getType());
    }
}
