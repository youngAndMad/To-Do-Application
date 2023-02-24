package daneker.code.todo_web_application.services;

import daneker.code.todo_web_application.models.Client;
import daneker.code.todo_web_application.repositories.NoteRepository;
import daneker.code.todo_web_application.models.Note;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final ClientService clientService;

    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public List<Note> getClientNotesById(Long id) {
        return noteRepository.getNotesByOwnerId(id);
    }

    public Note saveNote(Note note , Long ownerId) {
        Client client = clientService.getClientById(ownerId);
        note.setOwner(client);
        note.setState("TODO");
        clientService.saveClient(client);
        return noteRepository.save(note);
    }

/*    public boolean updateTaskDeadline(String date, Long noteId) {
        Note note = getNoteById(noteId);
        if (note == null) {
            return false;
        }
        note.setDeadline(date);
        saveNote(note);
        return true;
    }

    public boolean updateTaskState(String state, Long noteId) {
        Note note = getNoteById(noteId);
        if (note == null) {
            return false;
        }
        note.setState(state);
        saveNote(note);
        return true;
    }*/

}
