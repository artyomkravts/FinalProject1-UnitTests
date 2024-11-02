import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientMockIngredientAdded() {
        burger.addIngredient(mockIngredient);

        Assert.assertTrue(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void setBunsMockBunSet() {
        burger.setBuns(mockBun);

        Assert.assertEquals(burger.bun, mockBun);
    }

    @Test
    public void removeIngredientMockIngredientRemoved() {
        burger.addIngredient(mockIngredient);
        burger.removeIngredient(0);

        Assert.assertFalse(burger.ingredients.contains(mockIngredient));
    }

    @Test
    public void moveIngredientFromZeroToFirstIndexMoved() {
        Ingredient mockIngredient2 = mock(Ingredient.class);
        burger.addIngredient(mockIngredient);
        burger.addIngredient(mockIngredient2);

        burger.moveIngredient(0, 1);

        Assert.assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceStubPricesCorrectReturn() {
        Mockito.when(mockBun.getPrice()).thenReturn(5.1f);
        Mockito.when(mockIngredient.getPrice()).thenReturn(5.2f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        Assert.assertEquals(15.4f, burger.getPrice(), 0.0001f);
        System.out.println(burger.getPrice());
    }

    @Test
    public void getReceipt() {
        Mockito.when(mockBun.getName()).thenReturn("Ржаная булка");
        Mockito.when(mockIngredient.getName()).thenReturn("Адская котлета");
        Mockito.when(mockIngredient.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient);

        System.out.println(burger.getReceipt());
    }

}
