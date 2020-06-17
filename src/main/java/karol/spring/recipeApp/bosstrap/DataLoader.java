package karol.spring.recipeApp.bosstrap;

import karol.spring.recipeApp.models.*;
import karol.spring.recipeApp.repositories.CategoryRepository;
import karol.spring.recipeApp.repositories.RecipeRepository;
import karol.spring.recipeApp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public DataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){

        List<Recipe> recipes = new ArrayList<>();

        //pobieranie UnitOfMeasure z bazy

        Optional<UnitOfMeasure> teaspoonUOMOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        Optional<UnitOfMeasure> tablespoonUOMOptional  = unitOfMeasureRepository.findByDescription("Tablespoon");

        Optional<UnitOfMeasure> cupUOMOptional  = unitOfMeasureRepository.findByDescription("Cup");

        Optional<UnitOfMeasure> pinchUOMOptional  = unitOfMeasureRepository.findByDescription("Pinch");

        Optional<UnitOfMeasure> eachUOMOptional  = unitOfMeasureRepository.findByDescription("Each");

        Optional<UnitOfMeasure> pintUOMOptional  = unitOfMeasureRepository.findByDescription("Pint");

        Optional<UnitOfMeasure> dashUOMOptional  = unitOfMeasureRepository.findByDescription("Dash");

        UnitOfMeasure teaspoonUOM = teaspoonUOMOptional.get();
        UnitOfMeasure tablespoonUOM = tablespoonUOMOptional.get();
        UnitOfMeasure cupUOM = cupUOMOptional.get();
        UnitOfMeasure pinchUOM = pinchUOMOptional.get();
        UnitOfMeasure eachUOM = eachUOMOptional.get();
        UnitOfMeasure pintUOM = pintUOMOptional.get();
        UnitOfMeasure dashUOM = dashUOMOptional.get();

        //pibieranie Categorie z bazy

        Optional<Category> polishCategoryOptional = categoryRepository.findByDescription("Polish");

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");

        Category polishCategory = polishCategoryOptional.get();
        Category americanCategory = americanCategoryOptional.get();
        Category italianCateogory = italianCategoryOptional.get();
        Category fastFoodCategory = fastFoodCategoryOptional.get();

        //Adding new recipe

        //todo put real recipes

        Recipe recipe = new Recipe();
        recipe.setDescription("Test recipe");
        recipe.setPrepTime(10);
        recipe.setCookTime(5);
        recipe.setDifficulty(Difficulty.EASE);
        recipe.setDescription("\"1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon\" +\n" +
                "                \"\\n\" +\n" +
                "                \"2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\" +\n" +
                "                \"\\n\"");
        Notes notes = new Notes();
        notes.setRecipeNote("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your");
        notes.setRecipe(recipe);
        recipe.setNotes(notes);
        recipe.getIngredients().add(new Ingredient("test testing", new BigDecimal(2), recipe, teaspoonUOM));
        recipe.getCategories().add(polishCategory);
        recipe.getCategories().add(americanCategory);
        recipes.add(recipe);

        return recipes;
    }
}