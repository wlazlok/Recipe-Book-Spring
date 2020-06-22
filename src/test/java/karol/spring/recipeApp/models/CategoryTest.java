package karol.spring.recipeApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class CategoryTest {

    Category category;


    @BeforeEach
    void setUp() {
        category = new Category();
    }

    @Test
    void getId() {
        Long idValue = 1L;
        category.setId(idValue);

        assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
        String desc = "Some string";
        category.setDescription(desc);

        assertEquals(desc, category.getDescription());
    }
}