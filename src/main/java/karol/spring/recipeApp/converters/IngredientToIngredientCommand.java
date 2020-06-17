package karol.spring.recipeApp.converters;

import karol.spring.recipeApp.commands.IngredientsCommand;
import karol.spring.recipeApp.models.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientsCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public IngredientsCommand convert(Ingredient source) {
        if(source == null)
            return null;
        IngredientsCommand ingredientsCommand = new IngredientsCommand();
        ingredientsCommand.setId(source.getId());
        ingredientsCommand.setAmount(source.getAmount());
        ingredientsCommand.setDescription(source.getDescription());
        ingredientsCommand.setRecipeId(source.getRecipe().getId());
        ingredientsCommand.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureCommand.convert(source.getUnitOfMeasure()));

        return ingredientsCommand;
    }
}
