package daneker.code.todo_web_application.controllers;

import daneker.code.todo_web_application.models.Note;
import daneker.code.todo_web_application.services.ClientService;
import daneker.code.todo_web_application.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("note")
public class NoteController {
    private final NoteService noteService;
    private final ClientService clientService;

    @PostMapping("/{id}")
    public String saveNote(@ModelAttribute("note") Note note , @PathVariable("id") Long id, Model model){
        noteService.saveNote(note,id);
        model.addAttribute("client" , clientService.getClientById(id));
        return "redirect:/client/page/" + id;
    }
}
