package de.instantmessenger.app.ui.view;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import de.instantmessenger.app.ui.component.RegisterComponent;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the register-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Push
@Tag("register-view")
@JsModule("./register-view.js")
@Route("register")
public class RegisterView extends PolymerTemplate<RegisterView.RegisterViewModel> {

    @Id("registerComponent")
	private RegisterComponent registerComponent;

	/**
     * Creates a new RegisterView.
     */
    public RegisterView() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between RegisterView and register-view
     */
    public interface RegisterViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
