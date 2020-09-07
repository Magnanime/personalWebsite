package com.Magnanime.personalWebsite.Exceptions;

//Custom exception for not existing article

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String message) {
        super(message);
    }
}