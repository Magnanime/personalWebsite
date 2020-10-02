package com.Magnanime.personalWebsite.WebControllers;

import com.Magnanime.personalWebsite.DTO.ImagePathResponse;
import com.Magnanime.personalWebsite.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/uploads/")
public class UploadController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/image")
    public ImagePathResponse uploadImage (@RequestParam("imageFile") MultipartFile image) throws IOException {
        return new ImagePathResponse(imageService.save(image));
    }
}