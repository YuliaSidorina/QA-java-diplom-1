import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private static final float DELTA = 0.001f;

    private final Bun bun;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(Bun bun, String expectedName, float expectedPrice) {
        this.bun = bun;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Bun("Sesame", 2.0f), "Sesame", 2.0f},
        });
    }

    @Test
    public void testBunName() {
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void testBunPrice() {
        assertEquals(expectedPrice, bun.getPrice(), DELTA);
    }
}
