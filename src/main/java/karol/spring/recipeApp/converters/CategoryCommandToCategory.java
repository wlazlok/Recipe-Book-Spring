package karol.spring.recipeApp.converters;

import karol.spring.recipeApp.commands.CategoryCommand;
import karol.spring.recipeApp.models.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Karol Wlazło
 * recipeApp
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {


    @Override
    public Category convert(CategoryCommand source) {
        if(source == null)
            return null;
        Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());

        return category;
    }
}
