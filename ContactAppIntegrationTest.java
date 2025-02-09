package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.util.List;

public class ContactAppIntegrationTest {

    @Test
    public void testContactAppToStringIntegration() {
        ContactApp app = new ContactApp();
        app.nameField.setText("John Doe");
        app.phoneField.setText("123456789");
        app.emailField.setText("john.doe@example.com");
        app.saveContact();

        assertEquals("Name: John Doe, Phone: 123456789, Email: john.doe@example.com", app.contacts.get(0).toString());
    }

    @Test
    public void testSetupPanelsIntegration() {
        ContactApp app = new ContactApp();
        app.setupPanels();

        assertNotNull(app.cardPanel.getComponent(0));  // Contact List panel
        assertNotNull(app.cardPanel.getComponent(1));  // Details panel
        assertNotNull(app.cardPanel.getComponent(2));  // Form panel
    }

    @Test
    public void testCreateContactListPanelIntegration() {
        ContactApp app = new ContactApp();
        JPanel panel = app.createContactListPanel();

        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0);  // Should have components like the contact list
    }

    @Test
    public void testCreateDetailsPanelIntegration() {
        ContactApp app = new ContactApp();
        JPanel panel = app.createDetailsPanel();

        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0);  // Should contain components like labels for contact details
    }

    @Test
    public void testCreateFormPanelIntegration() {
        ContactApp app = new ContactApp();
        JPanel panel = app.createFormPanel();

        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0);  // Should have input fields and buttons for adding a new contact
    }

    @Test
    public void testSaveContactIntegration() {
        ContactApp app = new ContactApp();
        app.nameField.setText("John Doe");
        app.phoneField.setText("123456789");
        app.emailField.setText("john.doe@example.com");

        app.saveContact();

        List<Contact> contacts = app.contacts;  // Use generics for proper type casting
        assertEquals(1, contacts.size());
        assertEquals("John Doe", contacts.get(0).name);
    }

    @Test
    public void testShowContactDetailsIntegration() {
        ContactApp app = new ContactApp();
        app.contacts.add(new Contact("John Doe", "123456789", "john.doe@example.com"));
        app.listModel.addElement("John Doe");
        app.contactList.setSelectedIndex(0);  // Simulating a selection

        // Mock labels for testing, ensure these are initialized in your app
        JLabel nameLabel = new JLabel();
        JLabel phoneLabel = new JLabel();
        JLabel emailLabel = new JLabel();

        app.nameLabel = nameLabel;  // You might need to set them in the app class first
        app.phoneLabel = phoneLabel;
        app.emailLabel = emailLabel;

        app.showContactDetails();

        assertEquals("Name: John Doe", app.nameLabel.getText());
        assertEquals("Phone: 123456789", app.phoneLabel.getText());
        assertEquals("Email: john.doe@example.com", app.emailLabel.getText());
    }

    @Test
    public void testClearFormFieldsIntegration() {
        ContactApp app = new ContactApp();
        app.nameField.setText("John Doe");
        app.phoneField.setText("123456789");
        app.emailField.setText("john.doe@example.com");

        app.clearFormFields();

        assertEquals("", app.nameField.getText());
        assertEquals("", app.phoneField.getText());
        assertEquals("", app.emailField.getText());
    }

    @Test
    public void testShowCardIntegration() {
        ContactApp app = new ContactApp();

        app.showCard("DETAILS");

        assertNotNull(app.cardPanel); // Ensure cardPanel exists
        assertTrue(app.cardPanel.getComponent(1).isVisible());  // Details panel should be visible
    }
}
