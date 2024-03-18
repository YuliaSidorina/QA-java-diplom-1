import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.FILLING, "Lettuce", 1.0f},
                {IngredientType.SAUCE, "Ketchup", 0.5f}
        });
    }

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Test
    public void testIngredient() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(price, ingredient.getPrice(), 0.001);
        assertEquals(name, ingredient.getName());
        assertEquals(type, ingredient.getType());
    }
}
