package karol.spring.recipeApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class IngredientTest {

    Ingredient ingredient;

    @BeforeEach
    void setUp() {
        ingredient = new Ingredient();
    }

    @Test
    void getId() {
        Long idValue = 1L;

        ingredient.setId(idValue);
        assertEquals(idValue, ingredient.getId());
    }

    @Test
    void getDescription() {
        String desc = "Some string";
        ingredient.setDescription(desc);

        assertEquals(desc, ingredient.getDescription());
    }


    @Test
    void getRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        ingredient.setRecipe(recipe);

        assertEquals(recipe, ingredient.getRecipe());
    }

    @Test
    void getUnitOfMeasure() {
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(1L);

        ingredient.setUnitOfMeasure(unitOfMeasure);

        assertEquals(unitOfMeasure, ingredient.getUnitOfMeasure());
    }
}