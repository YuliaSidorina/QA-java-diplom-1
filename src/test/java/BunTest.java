import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BunTest {

    @Test
    public void testBunName() {
        Bun bun = new Bun("Sesame", 2.0f);
        assertEquals("Sesame", bun.getName());
    }

    @Test
    public void testBunPrice() {
        Bun bun = new Bun("Sesame", 2.0f);
        assertEquals(2.0f, bun.getPrice(), 0.001);
    }
}
