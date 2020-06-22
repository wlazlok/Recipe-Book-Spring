package karol.spring.recipeApp.bosstrap;

import karol.spring.recipeApp.models.*;
import karol.spring.recipeApp.repositories.CategoryRepository;
import karol.spring.recipeApp.repositories.RecipeRepository;
import karol.spring.recipeApp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
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

        Recipe recipe = new Recipe();
        recipe.setDescription("Pot Roast Tacos with Chimichurri");
        recipe.setPrepTime(10);
        recipe.setCookTime(5);
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setServing(8);
        recipe.setSource("culinary.net");
        recipe.setUrl("http://www.culinary.net/index.php/recipes/healthy/item/865-family-foods-with-a-weight-loss-focus");
        recipe.setDirection("1. To make chimichurri: In food processor, combine parsley, cilantro, onion and garlic until chopped.\n Add olive oil, lemon juice, water, salt and red pepper; process until fully combined.\n" +
                "2. To assemble tacos: In medium skillet over medium-high heat, cook chopped chuck roast 5 minutes. Remove from heat and mix in 1/2 cup chimichurri.\n In grill pan, char tortillas then fill evenly with meat, avocado, radishes and queso fresco. Serve with remaining chimichurri.");
        Notes notes = new Notes();
        notes.setRecipeNote("Very tasty food");
        notes.setRecipe(recipe);
        recipe.setNotes(notes);
        recipe.getIngredients().add(new Ingredient("Ingredient 1", new BigDecimal(2), recipe, teaspoonUOM));
        recipe.getIngredients().add(new Ingredient("Ingredient 2", new BigDecimal(2), recipe, dashUOM));
        recipe.getIngredients().add(new Ingredient("Ingredient 3", new BigDecimal(32), recipe, teaspoonUOM));
        recipe.getIngredients().add(new Ingredient("Ingredient 4", new BigDecimal(10), recipe, dashUOM));
        recipe.getIngredients().add(new Ingredient("Ingredient 5", new BigDecimal(5), recipe, pintUOM));
        recipe.getCategories().add(polishCategory);
        recipe.getCategories().add(americanCategory);

        recipes.add(recipe);

        Recipe recipe_1 = new Recipe();
        recipe_1.setDescription("Chili Loaded Baked Potato");

        recipe_1.setPrepTime(15);
        recipe_1.setCookTime(83);
        recipe_1.setServing(6);
        recipe_1.setDifficulty(Difficulty.HARD);
        recipe_1.setSource("culinary.net");
        recipe_1.setUrl("http://www.culinary.net/index.php/recipes/healthy/item/865-family-foods-with-a-weight-loss-focus");
        recipe_1.setDirection("1. Heat oven to 400° F. Line baking sheet or pan with parchment paper. Rinse and scrub sweet potatoes; pat dry with paper towel and pierce several times with fork or knife.\n Place in prepared pan. Lightly spray sweet potatoes with nonstick cooking spray and season with salt and pepper, to taste. Bake 45 minutes- 1 hour until tender when poked.\n" +
                "2. In pot, heat olive oil. Saute chuck until fully cooked. Drain fat and return to pot; add onion, garlic, chili powder, cumin, oregano, paprika and cayenne pepper.\n Reduce heat to medium-low and saute until onions are soft, about 10 minutes, stirring often.\n" +
                "3. Add broth, crushed tomatoes and vinegar to pot. Increase heat to high and bring to boil. Reduce to medium-low and simmer 10 minutes. Add butter beans, cilantro and chile; cook 5 minutes. Season with sea salt.\n" +
                "4. Split potatoes lengthwise; fluff flesh with fork. Top evenly with chili, yogurt, cilantro leaves and red onion.");
        Notes notes_1 = new Notes();
        notes_1.setRecipeNote("Very tasty food v2");
        notes_1.setRecipe(recipe_1);
        recipe_1.setNotes(notes_1);
        recipe_1.getIngredients().add(new Ingredient("Ingredient2_1", new BigDecimal(2), recipe_1, teaspoonUOM));
        recipe_1.getIngredients().add(new Ingredient("Ingredient2_2", new BigDecimal(2), recipe_1, dashUOM));
        recipe_1.getIngredients().add(new Ingredient("Ingredient2_3", new BigDecimal(32), recipe_1, teaspoonUOM));
        recipe_1.getIngredients().add(new Ingredient("Ingredient2_4", new BigDecimal(10), recipe_1, dashUOM));
        recipe_1.getIngredients().add(new Ingredient("Ingredient2_5", new BigDecimal(5), recipe_1, pintUOM));
        recipe_1.getCategories().add(polishCategory);
        recipe_1.getCategories().add(italianCateogory);

        recipes.add(recipe_1);

        return recipes;
    }
}
