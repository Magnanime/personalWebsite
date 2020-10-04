package com.Magnanime.personalWebsite;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class PersonalWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalWebsiteApplication.class, args);
	}

}
