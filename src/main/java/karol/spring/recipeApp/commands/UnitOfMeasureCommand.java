package karol.spring.recipeApp.commands;

/**
 * @author Karol Wlazło
 * recipeApp
 */
public class UnitOfMeasureCommand {

    private Long id;
    private String description;

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
}
