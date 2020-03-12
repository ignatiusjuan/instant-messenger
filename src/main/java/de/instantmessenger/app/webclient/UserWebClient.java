package de.instantmessenger.app.webclient;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import de.instantmessenger.app.model.User;
import reactor.core.publisher.Mono;

public class UserWebClient {
	private WebClient client = WebClient.create("http://localhost:8080");

    Mono<ClientResponse> result = client.get()
            .uri("api/users/5e2340c0eba16f2bfc7372d1")
            .accept(MediaType.APPLICATION_JSON)
            .exchange();
    
	public String getResult() {
		return result.flatMap(res -> res.bodyToMono(String.class)).block();
	}
}
