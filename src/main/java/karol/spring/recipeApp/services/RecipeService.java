package karol.spring.recipeApp.services;

import karol.spring.recipeApp.commands.RecipeCommand;
import karol.spring.recipeApp.models.Recipe;

import javax.persistence.Lob;
import java.util.List;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public interface RecipeService {

    List<Recipe> getRecipes();

    Recipe findById(Long id);

    void deleteById(Long id);

    RecipeCommand findCommandById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
