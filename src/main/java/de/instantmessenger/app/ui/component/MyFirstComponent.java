package de.instantmessenger.app.ui.component;

import com.vaadin.flow.templatemodel.TemplateModel;

import de.instantmessenger.app.model.User;
import de.instantmessenger.app.service.UserService;
import de.instantmessenger.app.ui.view.FirstView;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.page.Push;

/**
 * A Designer generated component for the my-first-component template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Tag("my-first-component")
@JsModule("./my-first-component.js")
public class MyFirstComponent extends PolymerTemplate<MyFirstComponent.MyFirstComponentModel> {

	@Id("vaadinTextField")
	private TextField vaadinTextField;
	@Id("vaadinButton")
	private Button vaadinButton;
	@Id("label")
	private Label label;

	SerializableConsumer<FirstView.PersonDTO> personDTOConsumer = null;

	public void setPersonDTOConsumer(SerializableConsumer<FirstView.PersonDTO> personDTOConsumer) {
		this.personDTOConsumer = personDTOConsumer;
	}

	/**
	 * Creates a new MyFirstComponent.
	 */
	public MyFirstComponent(UserService service, UI ui) {

		vaadinButton.addClickListener(buttonClickEvent -> {
			// create dto for input data
			final FirstView.PersonDTO personDTO = new FirstView.PersonDTO(vaadinTextField.getValue(),
					LocalDateTime.now());

			label.setText(String.format("Hello %s, it is %s", personDTO.getName(), personDTO.getSubmitTime()));

			// accept data if consumer exist
			if (personDTOConsumer != null) {
				personDTOConsumer.accept(personDTO);
			}
		});
	}

	/**
	 * This model binds properties between MyFirstComponent and my-first-component
	 */
	public interface MyFirstComponentModel extends TemplateModel {
		// Add setters and getters for template properties here.
	}
}
