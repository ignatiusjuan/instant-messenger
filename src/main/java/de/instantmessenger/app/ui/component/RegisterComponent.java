package de.instantmessenger.app.ui.component;

import com.vaadin.flow.templatemodel.TemplateModel;

import de.instantmessenger.app.controller.UserController;
import de.instantmessenger.app.model.User;
import de.instantmessenger.app.repository.UserRepository;
import de.instantmessenger.app.webclient.UserWebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;

/**
 * A Designer generated component for the register-component template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Tag("register-component")
@JsModule("./register-component.js")
public class RegisterComponent extends PolymerTemplate<RegisterComponent.RegisterComponentModel> {

	@Id("txtFirstName")
	private TextField txtFirstName;
	@Id("txtLastName")
	private TextField txtLastName;
	@Id("txtEmailAddress")
	private TextField txtEmailAddress;
	@Id("pwdPassword")
	private PasswordField pwdPassword;
	@Id("btnRegister")
	private Button btnRegister;
	@Id("emailStatus")
	private Label emailStatus;

	private UserController userController;

	/**
	 * Creates a new RegisterComponent.
	 */
	public RegisterComponent() {
		register();
	}

	public void register() {
		/*
		btnRegister.addClickListener(click -> {
			
			WebClient client = WebClient.create("http://localhost:8080");
			
			User user = new User(txtFirstName.getValue(), txtLastName.getValue(), txtEmailAddress.getValue(), pwdPassword.getValue());
			
		    Mono<ClientResponse> resultPost = client.post()
		            .uri("api/users/")
		            .body(BodyInserters.fromObject(user))
		            .header("content-type", "application/json")
		            .exchange();
		    
		    resultPost.subscribe(res -> System.out.println("User " + user.getFirstName() + " " + user.getLastName() + " wurde angelegt."));

		    Mono<ClientResponse> resultGet = client.get()
		            .uri("api/users/5e2340c0eba16f2bfc7372d1")
		            .accept(MediaType.APPLICATION_JSON)
		            .exchange();
		    
		    resultGet.flatMap(res -> res.bodyToMono(String.class)).subscribe(r -> System.out.println(r.toString()));
		});
		
		*/
	}

	/* testing some things */
	public boolean checkName(String name) {
		if (name.equals("Matt")) {
			return true;
		}
		return false;
	}

	/**
	 * This model binds properties between RegisterComponent and register-component
	 */
	public interface RegisterComponentModel extends TemplateModel {
		// Add setters and getters for template properties here.
	}
}
