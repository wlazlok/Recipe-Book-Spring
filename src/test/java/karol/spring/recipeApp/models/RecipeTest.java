package karol.spring.recipeApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class RecipeTest {

    Recipe recipe;

    @BeforeEach
    void setUp() {
        recipe = new Recipe();
    }

    @Test
    void getId() {
        Long idValue = 1L;
        recipe.setId(idValue);

        assertEquals(idValue, recipe.getId());
    }

    @Test
    void getDescription() {
        String desc = "Some string";
        recipe.setDescription(desc);

        assertEquals(desc, recipe.getDescription());
    }

    @Test
    void getSource() {
        String source = "goodpage.com";
        recipe.setSource(source);

        assertEquals(source, recipe.getSource());
    }

    @Test
    void getUrl() {
        String source = "goodpage.com";
        recipe.setUrl(source);

        assertEquals(source, recipe.getUrl());
    }

    @Test
    void getDirection() {
        String direction = "Some good text";
        recipe.setDirection(direction);

        assertEquals(direction, recipe.getDirection());
    }


    @Test
    void getDifficulty() {
        Difficulty difficulty = Difficulty.EASY;
        recipe.setDifficulty(difficulty);

        assertEquals(difficulty, recipe.getDifficulty());
    }

    @Test
    void getNotes() {
        Notes notes = new Notes();
        notes.setId(1L);
        recipe.setNotes(notes);

        assertEquals(notes, recipe.getNotes());
    }

    @Test
    void getIngredients() {
        List<Ingredient> ingredientList = new ArrayList<>();

        Ingredient ingredient = new Ingredient();
        ingredient.setId(1L);

        ingredientList.add(ingredient);
        recipe.setIngredients(ingredientList);

        assertEquals(ingredientList.size(), recipe.getIngredients().size());
    }

    @Test
    void getCategories() {
        List<Category> categoryList = new ArrayList<>();
        Category category = new Category();
        category.setId(1L);
        categoryList.add(category);
        recipe.setCategories(categoryList);

        assertEquals(categoryList.size(), recipe.getCategories().size());
    }

    @Test
    void getPrepTime() {
        Integer prepTime = 10;
        recipe.setPrepTime(prepTime);

        assertEquals(prepTime, recipe.getPrepTime());
    }

    @Test
    void getCookTime() {
        Integer cookTime = 50;
        recipe.setCookTime(cookTime);

        assertEquals(cookTime, recipe.getCookTime());
    }

    @Test
    void getServing() {
        Integer servings = 2;
        recipe.setServing(servings);

        assertEquals(servings, recipe.getServing());
    }
}