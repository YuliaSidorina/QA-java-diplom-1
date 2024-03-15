import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BunTest {

    private final String bunName;
    private final float bunPrice;

    public BunTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Sesame", 2.0f},
        });
    }

    @Test
    public void testBunName() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getName()).thenReturn(bunName);
        assertEquals(bunName, bunMock.getName());
    }

    @Test
    public void testBunPrice() {
        Bun bunMock = mock(Bun.class);
        when(bunMock.getPrice()).thenReturn(bunPrice);
        assertEquals(bunPrice, bunMock.getPrice(), 0.001);
    }
}
