package karol.spring.recipeApp.services;

import karol.spring.recipeApp.models.Ingredient;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public interface IngredientService {

    Ingredient findByRecipeIdAndIngredient(Long recipeId, Long ingredientId);

    void deleteById(Long recipeId, Long ingredientId);

}
