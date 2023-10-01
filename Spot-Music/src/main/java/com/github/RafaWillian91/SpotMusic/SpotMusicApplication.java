package com.github.RafaWillian91.SpotMusic;

import com.github.RafaWillian91.SpotMusic.model.Music;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.RepositoryDefinition;

@SpringBootApplication
@ComponentScan(basePackages = "com.github.RafaWillian91.SpotMusic")
@EntityScan("com.github.RafaWillian91.SpotMusic.model")
public class SpotMusicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotMusicApplication.class, args);
	}

}
