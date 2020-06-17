package karol.spring.recipeApp.services;

import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>();
        recipeRepository.findAll().forEach(recipes::add);

        return recipes;
    }

    @Override
    public Recipe findById(Long id) {

        return recipeRepository.findById(id).get();
    }
}
