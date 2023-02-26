package daneker.code.todo_web_application.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class Converter {
    public static Image toImage(MultipartFile multipartFile) throws IOException {
        Image image = new Image();
        image.setOriginalName(multipartFile.getOriginalFilename());
        image.setContentType(multipartFile.getContentType());
        image.setBytes(multipartFile.getBytes());
        image.setSize(multipartFile.getSize());
        return image;
    }
}
