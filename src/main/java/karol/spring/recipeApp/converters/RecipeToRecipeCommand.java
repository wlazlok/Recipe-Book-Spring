package karol.spring.recipeApp.converters;

import karol.spring.recipeApp.commands.RecipeCommand;
import karol.spring.recipeApp.models.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryToCategoryCommand;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final NotesToNotesCommand notesToNotesCommand;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryToCategoryCommand, IngredientToIngredientCommand ingredientToIngredientCommand, NotesToNotesCommand notesToNotesCommand) {
        this.categoryToCategoryCommand = categoryToCategoryCommand;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
        this.notesToNotesCommand = notesToNotesCommand;
    }

    @Override
    public RecipeCommand convert(Recipe source) {

        if(source == null)
            return null;

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(source.getId());
        recipeCommand.setCookTime(source.getCookTime());
        recipeCommand.setPrepTime(source.getPrepTime());
        recipeCommand.setDescription(source.getDescription());
        recipeCommand.setDifficulty(source.getDifficulty());
        recipeCommand.setServings(source.getServing());
        recipeCommand.setDirections(source.getDirection());
        recipeCommand.setUrl(source.getUrl());
        recipeCommand.setImage(source.getImage());
        recipeCommand.setSource(source.getSource());
        recipeCommand.setNotes(notesToNotesCommand.convert(source.getNotes()));

        if(source.getCategories() != null && source.getCategories().size() > 0)
            source.getCategories().forEach(cat -> recipeCommand.getCategories().add(categoryToCategoryCommand.convert(cat)));

        if(source.getIngredients() != null && source.getIngredients().size() > 0)
            source.getIngredients().forEach(ing -> recipeCommand.getIngredients().add(ingredientToIngredientCommand.convert(ing)));



        return recipeCommand;
    }
}
