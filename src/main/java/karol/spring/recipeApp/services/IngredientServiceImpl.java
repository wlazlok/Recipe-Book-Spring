package karol.spring.recipeApp.services;

import karol.spring.recipeApp.commands.IngredientsCommand;
import karol.spring.recipeApp.converters.IngredientCommandToIngredient;
import karol.spring.recipeApp.converters.IngredientToIngredientCommand;
import karol.spring.recipeApp.models.Ingredient;
import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.repositories.RecipeRepository;
import karol.spring.recipeApp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.Optional;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, IngredientCommandToIngredient ingredientCommandToIngredient, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
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

    @Override
    public IngredientsCommand saveIngredientCommand(IngredientsCommand command) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(command.getRecipeId());
        
        if(!recipeOptional.isPresent()){
            return new IngredientsCommand();
        }else{
            Recipe recipe = recipeOptional.get();

            Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream().filter(ing -> ing.getId().equals(command.getId())).findFirst();

            if(ingredientOptional.isPresent()){
                Ingredient ingredientFound = ingredientOptional.get();
                ingredientFound.setDescription(command.getDescription());
                ingredientFound.setAmount(command.getAmount());
                ingredientFound.setUnitOfMeasure(unitOfMeasureRepository.findById(command.getUnitOfMeasure().getId()).orElseThrow( () -> new RuntimeException("UOM NOT FOUND")));
            }else{
                Ingredient ingredient = ingredientCommandToIngredient.convert(command);
                ingredient.setRecipe(recipe);
                recipe.getIngredients().add(ingredient);
            }

            Recipe savedRecipe = recipeRepository.save(recipe);

            Optional<Ingredient> savedIngredientOptional = savedRecipe.getIngredients().stream()
                    .filter(recipeIngredients -> recipeIngredients.getId().equals(command.getId()))
                    .findFirst();
            if(savedIngredientOptional.isPresent()) {
                savedIngredientOptional = savedRecipe.getIngredients().stream()
                        .filter(recipeIngredients -> recipeIngredients.getDescription().equals(command.getDescription()))
                        .filter(recipeIngredients -> recipeIngredients.getAmount().equals(command.getAmount()))
                        .filter(recipeIngredients -> recipeIngredients.getUnitOfMeasure().getId().equals(command.getUnitOfMeasure().getId()))
                        .findFirst();
            }

            return ingredientToIngredientCommand.convert(savedIngredientOptional.get());

        }

    }

}
