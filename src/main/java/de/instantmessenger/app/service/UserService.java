package de.instantmessenger.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;

import de.instantmessenger.app.model.User;
import de.instantmessenger.app.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Mono<User> register(User user) {
		return userRepository.insert(user);
	}
	
	// upsert - update or insert
	public Mono<User> save(User user) {
		return userRepository.save(user);
	}
	
	public Mono<User> findById(String id) {
		return userRepository.findById(id);
		
	}
}
