package daneker.code.todo_web_application.services;

import daneker.code.todo_web_application.repositories.ImageRepository;
import daneker.code.todo_web_application.utils.Image;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    public Optional<Image> findById(Integer id){
        return imageRepository.findById(id);
    }
}
