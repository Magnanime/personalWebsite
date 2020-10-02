package com.Magnanime.personalWebsite.Service;

import com.Magnanime.personalWebsite.Configuration.ApplicationConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

@Service
public class ImageService {

    @Autowired
    ApplicationConfigurationProperties properties;

    public String makeUniqueFilename(String filename){
        String uniqueFilename = Instant.now().getEpochSecond() + filename;
        return uniqueFilename;
    }

    public String createImageDirectory(){
        //Get image storage directory path
        String dir = System.getProperty("user.dir") + properties.getImageSaveDirName();
        //Create directory if not existent
        new File(dir).mkdirs();
        //Return created directory
        return dir;
    }

    public String save(MultipartFile image) throws IOException {
        //Initialise directory
        String dir = createImageDirectory();
        //Set unique filename (orig filename + seconds past since Java era)
        String newName = makeUniqueFilename(image.getOriginalFilename());
        Path path = Paths.get(dir + newName);
        Files.write(path, image.getBytes());
        return properties.getImageHostUrl() + newName;
    }
}
