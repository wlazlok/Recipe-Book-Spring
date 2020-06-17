package karol.spring.recipeApp.controllers;

import karol.spring.recipeApp.commands.IngredientsCommand;
import karol.spring.recipeApp.services.IngredientService;
import karol.spring.recipeApp.services.RecipeService;
import karol.spring.recipeApp.services.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Karol Wlazło
 * recipeApp
 */
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String showIngredientOfRecipe(@PathVariable String recipeId, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(recipeId)));

        return "recipe/ingredientList";
    }

    @GetMapping("/recipe/{recipeId}/ingredients/{ingId}/show")
    public String showIngredientFromList(@PathVariable String recipeId, @PathVariable String ingId, Model model){

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredient(Long.valueOf(recipeId), Long.valueOf(ingId)));

        return "recipe/showIgredientFromList";
    }

    @GetMapping("/recipe/{recipeId}/ingredients/{ingId}/delete")
    public String deleteIngredient(@PathVariable String recipeId, @PathVariable String ingId){

        ingredientService.deleteById(Long.valueOf(recipeId), Long.valueOf(ingId));

        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
    @GetMapping("/recipe/{recipeId}/ingredients/{ingId}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String ingId, Model model){

        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredient(Long.valueOf(recipeId), Long.valueOf(ingId)));
        model.addAttribute("uomList", unitOfMeasureService.listAllUnitOfMeasure());

        return "recipe/updateIngredientForm";
    }

    @PostMapping("recipe/{recipeId}/ingredients")
    private String saveOrUpdate(@ModelAttribute IngredientsCommand command){

        IngredientsCommand saveCommand = ingredientService.saveIngredientCommand(command);

        return "redirect:/recipe/" + saveCommand.getRecipeId() + "/ingredients/" + saveCommand.getId() + "/show";

    }

}
