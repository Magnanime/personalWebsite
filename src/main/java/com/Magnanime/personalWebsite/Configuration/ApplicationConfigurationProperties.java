package com.Magnanime.personalWebsite.Configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix="custom")
@Component

public class ApplicationConfigurationProperties {
    /** Url properties */
    private String imageHostUrl;
    private String baseUrl;

    /** File System properties */
    private String imageSaveDirName;

    /** Email properties */
    private String registrationResponseTitle;
    private String registrationResponseBody;
    private String registrationFrom;

    /** Keystore properties */
    private String keystorePassword;
}
