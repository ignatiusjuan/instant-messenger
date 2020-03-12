package de.instantmessenger.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import de.instantmessenger.app.model.Chat;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {

}
