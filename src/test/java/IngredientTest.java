import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class IngredientTest {

    @Test
    public void testFillingIngredient() {
        IngredientType type = IngredientType.FILLING;
        String name = "Lettuce";
        float price = 1.0f;

        Ingredient filling = mock(Ingredient.class);
        filling.setType(type);
        filling.setName(name);
        filling.setPrice(price);

        assertEquals(price, filling.getPrice(), 0.001);
        assertEquals(name, filling.getName());
        assertEquals(type, filling.getType());
    }

    @Test
    public void testSauceIngredient() {
        IngredientType type = IngredientType.SAUCE;
        String name = "Ketchup";
        float price = 0.5f;

        Ingredient sauce = mock(Ingredient.class);
        sauce.setType(type);
        sauce.setName(name);
        sauce.setPrice(price);

        assertEquals(price, sauce.getPrice(), 0.001);
        assertEquals(name, sauce.getName());
        assertEquals(type, sauce.getType());
    }
}
