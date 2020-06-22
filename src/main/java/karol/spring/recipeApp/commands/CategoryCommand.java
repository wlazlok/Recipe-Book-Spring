package karol.spring.recipeApp.commands;

import karol.spring.recipeApp.models.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public class CategoryCommand {

    private Long id;
    private String description;

    List<Recipe> recipes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
