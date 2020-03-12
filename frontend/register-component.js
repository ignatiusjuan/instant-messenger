import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-password-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class RegisterComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; justify-content: flex-start; align-items: flex-start;">
 <h1>Register now</h1>
 <label>Register for free to get full access.</label>
 <vaadin-text-field label="First Name" placeholder="Enter first name" id="txtFirstName"></vaadin-text-field>
 <vaadin-text-field label="Last Name" placeholder="Enter last name" id="txtLastName"></vaadin-text-field>
 <vaadin-text-field label="E-mail address" placeholder="Enter e-mail address" id="txtEmailAddress"></vaadin-text-field>
 <vaadin-password-field label="Password" placeholder="Enter password" value="secret1" id="pwdPassword"></vaadin-password-field>
 <vaadin-button theme="primary" id="btnRegister">
  Register for free
 </vaadin-button>
 <label id="emailStatus">Label</label>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'register-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(RegisterComponent.is, RegisterComponent);
