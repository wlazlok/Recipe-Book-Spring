package karol.spring.recipeApp.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
class UnitOfMeasureTest {

    UnitOfMeasure unitOfMeasure;

    @BeforeEach
    void setUp() {
        unitOfMeasure = new UnitOfMeasure();
    }

    @Test
    void getId() {
        Long idValue = 1L;
        unitOfMeasure.setId(idValue);

        assertEquals(idValue, unitOfMeasure.getId());
    }

    @Test
    void getDescription() {
        String desc = "Some string";
        unitOfMeasure.setDescription(desc);

        assertEquals(desc, unitOfMeasure.getDescription());
    }
}