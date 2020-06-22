package karol.spring.recipeApp.services;

import karol.spring.recipeApp.commands.RecipeCommand;
import karol.spring.recipeApp.converters.RecipeCommandToRecipe;
import karol.spring.recipeApp.converters.RecipeToRecipeCommand;
import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository, recipeToRecipeCommand, recipeCommandToRecipe);
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeList);

        List<Recipe> recipeListInService = recipeService.getRecipes();

        assertEquals(recipeList.size(), recipeListInService.size());
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }

    @Test
    void findById() {
        Recipe recipe = new Recipe();
        recipe.setId(5L);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(5L);

        assertEquals(recipe, recipeReturned);
        assertNotNull(recipeReturned);

        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void deleteById() {
        Long idToDelete = 4L;

        recipeService.deleteById(idToDelete);

        verify(recipeRepository ,times(1)).deleteById(anyLong());
    }

    @Test
    void findCommandById() {
        Recipe recipe = new Recipe();
        recipe.setId(2L);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(2L);

        when(recipeToRecipeCommand.convert(any())).thenReturn(recipeCommand);

        RecipeCommand commandById = recipeService.findCommandById(1L);

        assertNotNull(commandById);
        assertEquals(recipeCommand, commandById);

        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void saveRecipeCommand() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(1L);

        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeCommandToRecipe.convert(any())).thenReturn(recipe);

        when(recipeService.saveRecipeCommand(any())).thenReturn(recipeCommand);

        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(recipeCommand);

        assertNotNull(savedRecipeCommand);
        assertEquals(recipeCommand, savedRecipeCommand);

    }
}