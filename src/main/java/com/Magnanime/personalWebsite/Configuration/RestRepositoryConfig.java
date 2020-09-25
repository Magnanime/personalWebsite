package com.Magnanime.personalWebsite.Configuration;

import com.Magnanime.personalWebsite.Model.Article;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        //This has to be configured manually because the frontend needs IDs of specific articles
        //and Spring does not expose them by default
        config.exposeIdsFor(Article.class);
    }
}
