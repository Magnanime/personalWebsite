package com.Magnanime.personalWebsite.WebControllers;

import com.Magnanime.personalWebsite.DTO.ImagePathResponse;
import com.Magnanime.personalWebsite.DTO.PostDto;
import com.Magnanime.personalWebsite.Service.ArticleService;
import com.Magnanime.personalWebsite.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDto postDto) {
        articleService.createPost(postDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(articleService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id) {
        return new ResponseEntity<>(articleService.readSinglePost(id), HttpStatus.OK);
    }

    @PostMapping("/image")
    public ImagePathResponse uploadImage (@RequestParam("imageFile") MultipartFile image) throws IOException {
        ImagePathResponse response = new ImagePathResponse();
        response.setPathName(imageService.save(image));
        return response;
    }
}