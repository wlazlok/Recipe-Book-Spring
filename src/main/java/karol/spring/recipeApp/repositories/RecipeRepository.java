package karol.spring.recipeApp.repositories;

import karol.spring.recipeApp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
