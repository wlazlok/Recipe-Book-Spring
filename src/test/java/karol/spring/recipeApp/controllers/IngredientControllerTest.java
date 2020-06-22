package karol.spring.recipeApp.controllers;

import karol.spring.recipeApp.commands.IngredientsCommand;
import karol.spring.recipeApp.commands.RecipeCommand;
import karol.spring.recipeApp.models.Ingredient;
import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.services.IngredientService;
import karol.spring.recipeApp.services.RecipeService;
import karol.spring.recipeApp.services.UnitOfMeasureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class IngredientControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    IngredientService ingredientService;
    @Mock

    UnitOfMeasureService unitOfMeasureService;

    IngredientController ingredientController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        ingredientController = new IngredientController(recipeService, ingredientService, unitOfMeasureService);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    void showIngredientOfRecipe() throws Exception {
        Recipe recipe = new Recipe();
        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(get("/recipe/1/ingredients"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/ingredientList"))
                .andExpect(model().attributeExists("recipe"));

        verify(recipeService, times(1)).findById(anyLong());
    }

    @Test
    void showIngredientFromList() throws Exception {
        Ingredient ingredient = new Ingredient();

        when(ingredientService.findByRecipeIdAndIngredient(anyLong(), anyLong())).thenReturn(ingredient);

        mockMvc.perform(get("/recipe/1/ingredients/3/show"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/showIgredientFromList"))
                .andExpect(model().attributeExists("ingredient"));

        verify(ingredientService, times(1)).findByRecipeIdAndIngredient(anyLong(), anyLong());
    }

    @Test
    void deleteIngredient() throws Exception {
        mockMvc.perform(get("/recipe/2/ingredients/3/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredients"));

        verify(ingredientService, times(1)).deleteById(anyLong(), anyLong());
    }

    @Test
    void updateRecipeIngredient() throws Exception {
        Ingredient ingredient = new Ingredient();

        when(ingredientService.findByRecipeIdAndIngredient(anyLong(), anyLong())).thenReturn(ingredient);
        when(unitOfMeasureService.listAllUnitOfMeasure()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/recipe/1/ingredients/2/update"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/updateIngredientForm"))
                .andExpect(model().attributeExists("ingredient"))
                .andExpect(model().attributeExists("uomList"));

        verify(ingredientService, times(1)).findByRecipeIdAndIngredient(anyLong(), anyLong());
        verify(unitOfMeasureService, times(1)).listAllUnitOfMeasure();
    }

    @Test
    void saveOrUpdate() throws Exception {
        IngredientsCommand command = new IngredientsCommand();
        command.setId(1L);
        command.setRecipeId(2L);

        when(ingredientService.saveIngredientCommand(any())).thenReturn(command);

        mockMvc.perform(post("/recipe/2/ingredients")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "")
                .param("description", "some string")
        )
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/recipe/2/ingredients/1/show"));
    }
}