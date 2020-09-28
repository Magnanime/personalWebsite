package com.Magnanime.personalWebsite.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    public String save(MultipartFile image) throws IOException {
        String dir = System.getProperty("user.dir") + "/images/";
        Path path = Paths.get(dir + image.getOriginalFilename());
        Files.write(path, image.getBytes());
        return "localhost:8080/images/" + image.getOriginalFilename();
    }
}
