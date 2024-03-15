import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;

    public IngredientTypeTest(IngredientType ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Collection<IngredientType> data() {
        return Arrays.asList(IngredientType.SAUCE, IngredientType.FILLING);
    }

    @Test
    public void testValueOf() {
        assertEquals(ingredientType, IngredientType.valueOf(ingredientType.name()));
    }

    @Test
    public void testValues() {
        assertEquals(2, IngredientType.values().length);
    }
}
