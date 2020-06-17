package karol.spring.recipeApp.controllers;

import karol.spring.recipeApp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author Karol Wlazło
 * recipeApp
 */

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/show/{id}")
    public String showRecipeById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

        return "recipe/show";
    }

    @GetMapping("/recipe/delete/{id}")
    public String deleteRecipeById(@PathVariable String id){

        recipeService.deleteById(Long.valueOf(id));

        return "redirect:/";
    }
}
