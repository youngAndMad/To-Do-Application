package daneker.code.todo_web_application.controllers;

import daneker.code.todo_web_application.models.Note;
import daneker.code.todo_web_application.services.ClientService;
import daneker.code.todo_web_application.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final NoteService noteService;


    @GetMapping("page/{id}")
    public String getClient(@PathVariable("id") Long id , Model model){
        model.addAttribute("client" , clientService.getClientById(id));
        model.addAttribute("notes"  ,noteService.getClientNotesById(id));
        model.addAttribute("newNote" ,new Note());
        return "client_page";
    }


}
