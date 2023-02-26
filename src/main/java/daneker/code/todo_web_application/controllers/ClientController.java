package daneker.code.todo_web_application.controllers;

import daneker.code.todo_web_application.models.Note;
import daneker.code.todo_web_application.services.ClientService;
import daneker.code.todo_web_application.services.NoteService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


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

    @GetMapping("/upload/{id}")
    public String displayUploadForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "image_upload_page";
    }

    @PostMapping("/upload/{id}")
    public String uploadImage(@NotNull @ModelAttribute("file") MultipartFile file,
                              @PathVariable("id") Long id)
            throws IOException {
        clientService.saveAvatar(id, file);
        return "redirect:/client/page/" + id;
    }


}
