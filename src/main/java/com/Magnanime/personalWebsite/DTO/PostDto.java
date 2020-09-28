package com.Magnanime.personalWebsite.DTO;

import lombok.Getter;
import lombok.Setter;

//Data transfer object for posts

@Getter
@Setter
public class PostDto {
    private Long id;
    private String content;
    private String title;
    private String username;
    private String desc;
    private String thumbnailPath;
}
