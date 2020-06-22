package karol.spring.recipeApp.services;

import karol.spring.recipeApp.converters.IngredientCommandToIngredient;
import karol.spring.recipeApp.converters.IngredientToIngredientCommand;
import karol.spring.recipeApp.models.Ingredient;
import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.repositories.RecipeRepository;
import karol.spring.recipeApp.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class IngredientServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;
    @Mock
    IngredientCommandToIngredient ingredientCommandToIngredient;
    @Mock
    IngredientToIngredientCommand ingredientToIngredientCommand;

    IngredientService ingredientService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        ingredientService = new IngredientServiceImpl(recipeRepository, unitOfMeasureRepository, ingredientCommandToIngredient, ingredientToIngredientCommand);
    }

    @Test
    void findByRecipeIdAndIngredient() {
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(2L);
        recipe.getIngredients().add(ingredient);
        ingredient.setRecipe(recipe);

        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Ingredient ingredient_result = ingredientService.findByRecipeIdAndIngredient(1L, 2L);


        assertEquals(optionalRecipe.get().getIngredients().get(0), ingredient_result);

        verify(recipeRepository, times(1)).findById(anyLong());

    }

    @Test
    void deleteById() {
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(3L);
        recipe.getIngredients().add(ingredient);
        ingredient.setRecipe(recipe);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        ingredientService.deleteById(1L, 3L);

        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

    @Test
    void saveIngredientCommand() {

    }
}