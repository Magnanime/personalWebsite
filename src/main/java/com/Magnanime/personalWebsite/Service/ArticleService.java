package com.Magnanime.personalWebsite.Service;

import com.Magnanime.personalWebsite.DTO.PostDto;
import com.Magnanime.personalWebsite.Exceptions.ArticleNotFoundException;
import com.Magnanime.personalWebsite.Model.Article;
import com.Magnanime.personalWebsite.Repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ArticleService {

    @Autowired
    private AuthService authService;
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public List<PostDto> showAllPosts() {
        List<Article> posts = articleRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    @Transactional
    public void createPost(PostDto postDto) {
        Article post = mapFromDtoToPost(postDto);
        articleRepository.save(post);
    }

    @Transactional
    public PostDto readSinglePost(Long id) {
        Article post = articleRepository.findById(id).orElseThrow(() -> new ArticleNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    private PostDto mapFromPostToDto(Article post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        System.out.println(postDto.getId());
        return postDto;
    }

    private Article mapFromDtoToPost(PostDto postDto) {
        Article post = new Article();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUsername(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());
        post.setShortContent(postDto.getDesc());
        return post;
    }
}