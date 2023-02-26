
package daneker.code.todo_web_application.controllers;

import daneker.code.todo_web_application.repositories.ImageRepository;
import daneker.code.todo_web_application.services.ImageService;
import daneker.code.todo_web_application.utils.Image;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;


@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/image/{id}")
    public ResponseEntity<?> getImagesById(@PathVariable("id") Integer id){
        Image image = imageService.findById(id).orElse(null);
        return ResponseEntity.
                ok().
                header("file" , image.getOriginalName()).
                contentType(MediaType.valueOf(image.getContentType())).
                contentLength(image.getSize()).
                body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
