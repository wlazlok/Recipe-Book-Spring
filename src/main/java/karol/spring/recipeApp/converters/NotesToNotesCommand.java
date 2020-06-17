package karol.spring.recipeApp.converters;

import karol.spring.recipeApp.commands.NotesCommand;
import karol.spring.recipeApp.models.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Karol Wlazło
 * recipeApp
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {


    @Override
    public NotesCommand convert(Notes source) {
        if(source == null)
            return null;
        NotesCommand notesCommand = new NotesCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNotes(source.getRecipeNote());

        return notesCommand;
    }
}
