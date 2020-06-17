package karol.spring.recipeApp.controllers;

import karol.spring.recipeApp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Controller
public class IndexContrroller {

    private final RecipeService recipeService;

    public IndexContrroller(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
