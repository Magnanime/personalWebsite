package com.Magnanime.personalWebsite.Repositories;

import com.Magnanime.personalWebsite.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//Repository for articles
//@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "article", path = "articles")
public interface ArticleRepository extends JpaRepository<Article, Long> {
}