package com.Magnanime.personalWebsite.Configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@ConfigurationProperties(prefix="custom")
@Component

public class ApplicationConfigurationProperties {
    /** Property value. */
    private String imageHostUrl;
    private String baseUrl;
    private String imageSaveDirName;
}
