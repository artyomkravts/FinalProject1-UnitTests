import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private Ingredient ingredient;
    private String randomName;
    private float randomPrice;

    @Mock
    private IngredientType mockIngredientType;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        Random random = new Random();
        randomName = RandomStringUtils.randomAlphabetic(15);
        randomPrice = random.nextFloat();
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

    @Test
    public void getTypeMockTypeReturnsCorrect() {
        Assert.assertEquals(mockIngredientType, ingredient.getType());
    }

}
