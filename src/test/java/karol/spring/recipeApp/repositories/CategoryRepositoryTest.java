package karol.spring.recipeApp.repositories;

import karol.spring.recipeApp.models.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Karol Wlazło
 * recipeApp
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void findByDescription() {
        Optional<Category> optionalCategory = categoryRepository.findByDescription("Polish");

        assertEquals("Polish", optionalCategory.get().getDescription());
    }
}