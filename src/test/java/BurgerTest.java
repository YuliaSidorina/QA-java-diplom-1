import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class BurgerTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {2.0f, 1.5f, 1.0f, 4.0f}, // Цена булки учитывается дважды
                {1.0f, 0.5f, 0.75f, 3.25f}, // Цена булки учитывается дважды
        });
    }

    private final float bunPrice;
    private final float ingredient1Price;
    private final float ingredient2Price;
    private final float expectedPrice;

    public BurgerTest(float bunPrice, float ingredient1Price, float ingredient2Price, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredient1Price = ingredient1Price;
        this.ingredient2Price = ingredient2Price;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void testGetPrice() {
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(bunPrice);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(ingredient1Price);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(ingredient2Price);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Ожидаемая цена должна быть суммой цены булки, умноженной на 2, и цен ингредиентов
        float expectedPrice = (bun.getPrice() * 2) + ingredient1.getPrice() + ingredient2.getPrice();

        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

    // Параметризованный тест для метода getReceipt() не требуется, так как метод не принимает аргументов

    @Test
    public void testMoveIngredient() {
        Bun bun = new Bun("Burger Bun", 2.0f);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Cheese", 1.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.5f);
        Ingredient ingredient3 = new Ingredient(IngredientType.FILLING, "Lettuce", 0.7f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(1, 2);

        assertEquals("Lettuce", burger.ingredients.get(1).getName());
    }

    @Test
    public void testRemoveIngredient() {
        Bun bun = new Bun("Burger Bun", 2.0f);
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "Cheese", 1.0f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "Ketchup", 0.5f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(1);

        assertEquals(1, burger.ingredients.size());
        assertEquals("Cheese", burger.ingredients.get(0).getName());
    }

    @Test
    public void testBurgerConstructor() {
        Burger burger = new Burger();

        // Проверяем, что при создании объекта Burger список ingredients пуст
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testAddIngredient() {
        Bun bun = new Bun("Burger Bun", 2.0f);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 1.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        // Проверяем, что ingredient успешно добавлен
        assertEquals(1, burger.ingredients.size());
        assertEquals("Cheese", burger.ingredients.get(0).getName());
    }

    @Test
    public void testSetBuns() {
        Bun bun = new Bun("Burger Bun", 2.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);

        // Проверяем, что bun успешно установлен
        assertEquals(bun, burger.bun);
    }
}
