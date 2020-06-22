package karol.spring.recipeApp.converters;

import karol.spring.recipeApp.commands.IngredientsCommand;
import karol.spring.recipeApp.models.Ingredient;
import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.models.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class IngredientToIngredientCommandTest {

    public static final Recipe RECIPE = new Recipe();
    public static final BigDecimal AMOUNT = new BigDecimal("1");
    public static final String DESCRIPTION = "description";
    public static final Long ID_VALUE = 1L;
    public static final Long UOM_ID = 2L;
    IngredientToIngredientCommand converter;

    @BeforeEach
    void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convert(null));
    }

    @Test
    void convert() {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ID_VALUE);
        ingredient.setDescription(DESCRIPTION);
        ingredient.setAmount(AMOUNT);
        ingredient.setRecipe(RECIPE);

        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(UOM_ID);

        ingredient.setUnitOfMeasure(unitOfMeasure);

        IngredientsCommand ingredientsCommand = converter.convert(ingredient);

        assertNotNull(ingredientsCommand);
        assertNotNull(ingredientsCommand.getUnitOfMeasure().getId());
        assertEquals(ID_VALUE, ingredientsCommand.getId());
        assertEquals(AMOUNT, ingredientsCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientsCommand.getDescription());
        assertEquals(UOM_ID, ingredientsCommand.getUnitOfMeasure().getId());
    }
}