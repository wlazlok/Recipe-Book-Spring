package karol.spring.recipeApp.services;

import karol.spring.recipeApp.models.Ingredient;
import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;

    public IngredientServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Ingredient findByRecipeIdAndIngredient(Long recipeId, Long ingredientId) {

        Recipe recipe = recipeRepository.findById(recipeId).get();

        Optional<Ingredient> ingredient = recipe.getIngredients().stream().filter(ing -> ing.getId().equals(ingredientId)).findFirst();

        return ingredient.get();
    }

    @Override
    public void deleteById(Long recipeId, Long ingredientId) {

        Recipe recipe = recipeRepository.findById(recipeId).get();

        Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream().filter(ing -> ing.getId().equals(ingredientId)).findFirst();

        Ingredient ingredientToDelete = ingredientOptional.get();
        ingredientToDelete.setRecipe(null);
        recipe.getIngredients().remove(ingredientOptional.get());
        recipeRepository.save(recipe);
    }

}
