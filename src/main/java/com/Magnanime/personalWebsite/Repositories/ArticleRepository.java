package com.Magnanime.personalWebsite.Repositories;

import com.Magnanime.personalWebsite.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository for articles

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}