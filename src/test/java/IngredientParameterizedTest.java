import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private Ingredient ingredient;
    private String randomName;
    private float randomPrice;

    @Mock
    private IngredientType mockIngredientType;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Ingredient1", 314f},
                {"Ingredient2", 45678f},
                {"Ingredient3", 0f}

    });
    }
    public IngredientParameterizedTest(String randomName, float randomPrice) {
        this.randomName = randomName;
        this.randomPrice = randomPrice;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        ingredient = new Ingredient(mockIngredientType, randomName, randomPrice);
    }

    @Test
    public void getNameRandomNameReturnsSame() {
        Assert.assertEquals(randomName, ingredient.getName());
    }

    @Test
    public void getPriceRandomPriceReturnsSame() {
        Assert.assertEquals(randomPrice, ingredient.getPrice(), 0);
    }

}
