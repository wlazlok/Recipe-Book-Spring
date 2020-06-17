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
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {


    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if(source == null)
            return null;
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(source.getId());
        unitOfMeasureCommand.setDescription(source.getDescription());

        return unitOfMeasureCommand;
    }
}
