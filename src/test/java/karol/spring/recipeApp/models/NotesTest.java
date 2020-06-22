package karol.spring.recipeApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class NotesTest {

    Notes notes;

    @BeforeEach
    void setUp() {
        notes = new Notes();
    }

    @Test
    void getId() {
        Long idValue = 1L;
        notes.setId(idValue);

        assertEquals(idValue, notes.getId());
    }

    @Test
    void getRecipe() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        notes.setRecipe(recipe);

        assertEquals(recipe, notes.getRecipe());
    }

    @Test
    void getRecipeNote() {
        String note = "Some string";
        notes.setRecipeNote(note);

        assertEquals(note, notes.getRecipeNote());
    }
}