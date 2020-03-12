package de.instantmessenger.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import de.instantmessenger.app.model.User;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

	public Mono<User> findByFirstName(String name);
}
