package com.Magnanime.personalWebsite.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImagePathResponse {
    private String pathName;

    public ImagePathResponse(String pathName){
        this.pathName = pathName;
    }
}
