import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;

    @Test
    public void getNameValidNameSuccessful() {
        bun = new Bun("New bun!", 24.6f);
        Assert.assertEquals("New bun!", bun.getName());
    }

    @Test
    public void getPriceValidPriceSuccessful() {
        bun = new Bun("New bun!", 24.6f);
        Assert.assertEquals(24.6f, bun.getPrice(), 0);
    }


}
