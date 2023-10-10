package com.github.RafaWillian91.SpotMusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.RafaWillian91.SpotMusic")
@EntityScan("com.github.RafaWillian91.SpotMusic.model")
@EnableJpaRepositories(basePackages = "com.github.RafaWillian91.SpotMusic.repository")
public class SpotMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotMusicApplication.class, args);
	}

}
