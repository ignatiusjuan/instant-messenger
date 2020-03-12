package de.instantmessenger.app;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import com.vaadin.flow.spring.annotation.EnableVaadin;

import de.instantmessenger.app.model.User;
import de.instantmessenger.app.repository.UserRepository;
import de.instantmessenger.app.webclient.UserWebClient;

/**
 * The entry point of the Spring Boot application.
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	/*@Bean
	CommandLineRunner users(UserRepository userRepository) {
		return args -> {
			userRepository.deleteAll().subscribe(null, null, () -> {
				Stream.of(new User("Luca", "Ja", "asd@htwsaar.de", "password"),
						new User("Prapor", "Doubleii", "prapori@example.org", "password")).forEach(user -> {
							userRepository.save(user).subscribe(System.out::println);
						});
			});
		};
	}*/
		
	public static void main(String[] args) {
	
		SpringApplication.run(Application.class, args);
		
		
		/*
		UserWebClient uwc = new UserWebClient();
		System.out.println(uwc.getResult());
		*/
	}

}
