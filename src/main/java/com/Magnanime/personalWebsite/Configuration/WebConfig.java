package com.Magnanime.personalWebsite.Configuration;


import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("*")
                .maxAge(3600L)
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .allowCredentials(true);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (SystemUtils.IS_OS_WINDOWS) {
            registry
                    .addResourceHandler("/images/**")
                    .addResourceLocations("file:///" + System.getProperty("user.dir") + "/images/");
        } else {
            registry
                    .addResourceHandler("/images/**")
                    .addResourceLocations("file:" + System.getProperty("user.dir") + "/images/");
        }
    }

}