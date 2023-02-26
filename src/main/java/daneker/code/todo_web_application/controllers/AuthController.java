package daneker.code.todo_web_application.controllers;

import daneker.code.todo_web_application.models.Client;
import daneker.code.todo_web_application.services.ClientService;
import daneker.code.todo_web_application.utils.Login;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

    private final ClientService clientService;


    @GetMapping()
    public String page(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }

    @GetMapping("/regis")
    public String registration(Model model) {
        model.addAttribute("client", new Client());
        model.addAttribute("isRegistered", false);
        return "registration";
    }

    @PostMapping()
    public String saveClient(@ModelAttribute("client") Client client, Model model) {
        boolean saved = clientService.saveClient(client);
        model.addAttribute("client", client);
        if (!saved) {
            model.addAttribute("isRegistered", true);
            return "registration";
        }
        return "redirect:/client/page/" + client.getId();
    }

    @GetMapping("red") // redirect
    public String check(@ModelAttribute("login") Login login, Model model) {

        Optional<Client> client = clientService.getByEmail(login.getEmail());

        if (client.isEmpty() || !client.get().getPassword().equals(login.getPassword())) {
            return "redirect:/auth";
        }

        model.addAttribute("client", client);
        return "redirect:/client/page/" + client.get().getId();
    }


}
