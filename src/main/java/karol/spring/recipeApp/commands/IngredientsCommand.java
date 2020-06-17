package karol.spring.recipeApp.commands;

import karol.spring.recipeApp.models.Recipe;
import karol.spring.recipeApp.models.UnitOfMeasure;
import org.springframework.context.annotation.Primary;

import java.math.BigDecimal;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public class IngredientsCommand {
    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasure;
    private Long recipeId;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public UnitOfMeasureCommand getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasureCommand unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
