package karol.spring.recipeApp.services;

import karol.spring.recipeApp.models.Recipe;
import java.util.List;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public interface RecipeService {

    List<Recipe> getRecipes();
}
