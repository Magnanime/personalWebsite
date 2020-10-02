package com.Magnanime.personalWebsite.Repositories;

import com.Magnanime.personalWebsite.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//Repository for articles
//@Repository
@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "article", path = "articles")
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findById(@Param("id") Integer id);
}