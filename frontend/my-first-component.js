import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class MyFirstComponent extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" theme="margin">
 <vaadin-horizontal-layout>
  <vaadin-text-field label="" placeholder="input your name" id="vaadinTextField" value="" has-value=""></vaadin-text-field>
  <vaadin-button theme="secondary" id="vaadinButton" style="margin-left: 1em;">
    Submit 
  </vaadin-button>
 </vaadin-horizontal-layout>
 <label id="label">Label</label>
 <label id="label1"></label>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'my-first-component';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(MyFirstComponent.is, MyFirstComponent);
