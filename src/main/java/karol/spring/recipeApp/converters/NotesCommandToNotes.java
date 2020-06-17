package karol.spring.recipeApp.converters;

import karol.spring.recipeApp.commands.NotesCommand;
import karol.spring.recipeApp.models.Notes;
import org.aspectj.weaver.ast.Not;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Karol Wlazło
 * recipeApp
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Override
    public Notes convert(NotesCommand source) {
        if(source == null)
            return null;
        Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNote(source.getRecipeNotes());

        return notes;
    }
}
