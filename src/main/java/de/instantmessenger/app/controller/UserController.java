package de.instantmessenger.app.controller;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;

import de.instantmessenger.app.model.User;
import de.instantmessenger.app.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/all")
	public Flux<User> getAll() {
		return null;
	}

	@GetMapping(value = "/{firstName}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> stream(@PathVariable("firstName") String firstName) {
		
		/*return userRepository.findByFirstName(firstName).flatMapMany(user -> {
			Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
			Flux<User> userFlux = Flux.fromStream(
					Stream.generate(() -> new User("joshkun", new Date().toString(), "kp@example.com", "pw")));
			return Flux.zip(interval, userFlux).map(Tuple2::getT2);
		});
		*/
		
		return null;
	}

	
	// .map() ist soweit ich gelesen habe synchron. Wir wollen aber asynchron das ganze haben. .flatMap() wäre asynchrone Variante, aber kann ich hier nicht anwenden wegen Mono<ResponseEntity<User>>
	@GetMapping("/{id}")
	public Mono<ResponseEntity<User>> findById(@PathVariable("id") String id) {
        return userService
                .findById(id)
                .map(user -> ResponseEntity.ok(user))
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PutMapping
	public Mono<User> register(@RequestBody User user) {
		return userService.register(user);
	}

	@PostMapping
	public Mono<User> update(@RequestBody User user) {
		return userService.save(user);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable("id") String id) {
		return null;
	}
}

