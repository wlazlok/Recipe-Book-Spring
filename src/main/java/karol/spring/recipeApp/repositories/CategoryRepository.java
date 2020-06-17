package karol.spring.recipeApp.repositories;

import karol.spring.recipeApp.models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
