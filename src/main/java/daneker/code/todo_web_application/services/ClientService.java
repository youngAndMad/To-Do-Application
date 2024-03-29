package daneker.code.todo_web_application.services;

import daneker.code.todo_web_application.models.Client;
import daneker.code.todo_web_application.repositories.ClientRepository;
import daneker.code.todo_web_application.repositories.ImageRepository;
import daneker.code.todo_web_application.utils.Converter;
import daneker.code.todo_web_application.utils.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ImageRepository imageRepository;

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public boolean saveClient(Client client) {
        if (getByEmail(client.getEmail()).isPresent()) {
            return false;
        }
        clientRepository.save(client);
        return true;
    }

    public Optional<Client> getClientByEmailAndPassword(String email, String password) {
        return clientRepository.getClientByEmailAndPassword(email, password);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> getByEmail(String email) {
        return clientRepository.getClientByEmail(email);
    }

    public void saveAvatar(Long clientId , MultipartFile multipartFile) throws IOException{
        Image image = Converter.toImage(multipartFile);
        Client client = getClientById(clientId);
        client.getAvatars().add(image);
        image.setClient(client);
        imageRepository.save(image);
        clientRepository.save(client);
    }
}
