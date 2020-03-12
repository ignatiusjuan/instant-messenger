package de.instantmessenger.app.ui.view;

import com.vaadin.flow.templatemodel.TemplateModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import de.instantmessenger.app.ui.component.MyFirstComponent;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.page.Push;

/**
 * A Designer generated component for the first-view template.
 *
 * Designer will add and remove fields with @Id mappings but does not overwrite
 * or otherwise change this file.
 */
@Push
@Tag("first-view")
@JsModule("./first-view.js")
@Route("first-view")
public class FirstView extends PolymerTemplate<FirstView.FirstViewModel> {

	@Id("myFirstComponent")
	private MyFirstComponent myFirstComponent;

	@Id("vaadinGrid")
	private Grid<PersonDTO> vaadinGrid;

	private List<PersonDTO> personDTOSet = new ArrayList<>();

	/**
     * Creates a new FirstView.
     */
    public FirstView() {
        // You can initialise any data required for the connected UI components here.
    	vaadinGrid.addColumn(PersonDTO::getName).setHeader("Name");
    	vaadinGrid.addColumn(PersonDTO::getSubmitTime).setHeader("Submit Time");
    	
    	myFirstComponent.setPersonDTOConsumer(personDTO -> {
    		personDTOSet.add(personDTO);
    		vaadinGrid.getDataProvider().refreshAll();
    	});
    	
    	vaadinGrid.setItems(personDTOSet);
    }

	/**
	 * This model binds properties between FirstView and first-view
	 */
	public interface FirstViewModel extends TemplateModel {
		// Add setters and getters for template properties here.
	}

	public static class PersonDTO {
		private String name;
		private LocalDateTime submitTime;

		public PersonDTO(String name, LocalDateTime submitTime) {
			this.name = name;
			this.submitTime = submitTime;
		}

		public String getName() {
			return name;
		}

		public LocalDateTime getSubmitTime() {
			return submitTime;
		}
	}
}
