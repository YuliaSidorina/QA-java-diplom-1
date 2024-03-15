import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    @Test
    public void testGetPrice() {
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(2.0f);

        Ingredient ingredient1 = mock(Ingredient.class);
        when(ingredient1.getPrice()).thenReturn(1.5f);

        Ingredient ingredient2 = mock(Ingredient.class);
        when(ingredient2.getPrice()).thenReturn(1.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        float expectedPrice = (bun.getPrice() * 2) + ingredient1.getPrice() + ingredient2.getPrice();

        assertEquals(expectedPrice, burger.getPrice(), 0.001);
    }

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
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void testAddIngredient() {
        Bun bun = new Bun("Burger Bun", 2.0f);
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 1.0f);

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(1, burger.ingredients.size());
        assertEquals("Cheese", burger.ingredients.get(0).getName());
    }

    @Test
    public void testSetBuns() {
        Bun bun = new Bun("Burger Bun", 2.0f);
        Burger burger = new Burger();
        burger.setBuns(bun);

        assertEquals(bun, burger.getBuns());
    }
}
