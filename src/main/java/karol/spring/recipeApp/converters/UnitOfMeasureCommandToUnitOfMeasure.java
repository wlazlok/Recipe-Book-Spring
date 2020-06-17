package karol.spring.recipeApp.converters;

import karol.spring.recipeApp.commands.UnitOfMeasureCommand;
import karol.spring.recipeApp.models.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Karol Wlazło
 * recipeApp
 */

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        if(source == null)
            return null;
        final UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(source.getId());
        unitOfMeasure.setDescription(source.getDescription());

        return unitOfMeasure;
    }
}
