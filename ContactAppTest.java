package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import java.util.List;

class ContactAppTest {
    @Test
    public void ToString() {
        Contact contact = new Contact("John Doe", "123456789", "john.doe@example.com");
        String result = contact.toString();

        assertEquals("Name: John Doe, Phone: 123456789, Email: john.doe@example.com", result);
    }

    @Test
    public void SetupPanels() {
        ContactApp app = new ContactApp();

        // Act
        app.setupPanels();

        // Assert
        assertNotNull(app.cardPanel.getComponent(0)); // Ensure the first panel (Contact List) is added
        assertNotNull(app.cardPanel.getComponent(1)); // Ensure the second panel (Details) is added
        assertNotNull(app.cardPanel.getComponent(2)); // Ensure the third panel (Form) is added
    }

    // Testing the createContactListPanel() method
    @Test
    public void CreateContactListPanel() {
        // Arrange
        ContactApp app = new ContactApp();

        // Act
        JPanel panel = app.createContactListPanel();

        // Assert
        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0); // Ensure the panel is populated with components
    }

    // Testing the createDetailsPanel() method
    @Test
    public void CreateDetailsPanel() {
        // Arrange
        ContactApp app = new ContactApp();

        // Act
        JPanel panel = app.createDetailsPanel();

        // Assert
        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0); // Ensure the panel has components like labels and buttons
    }

    // Testing the createFormPanel() method
    @Test
    public void CreateFormPanel() {
        // Arrange
        ContactApp app = new ContactApp();

        // Act
        JPanel panel = app.createFormPanel();

        // Assert
        assertNotNull(panel);
        assertTrue(panel.getComponentCount() > 0); // Ensure the panel has form fields and buttons
    }



    // Testing the saveContact() method
    @Test
    public void SaveContact() {
        // Arrange
        ContactApp app = new ContactApp();
        app.nameField.setText("John Doe");
        app.phoneField.setText("123456789");
        app.emailField.setText("john.doe@example.com");

        // Act
        app.saveContact();

        // Assert
        List<Contact> contacts = app.contacts;
        assertEquals(1, contacts.size());
        assertEquals("John Doe", contacts.get(0).name);
    }

    // Testing the showContactDetails() method
    @Test
    public void ShowContactDetails() {
        // Arrange
        ContactApp app = new ContactApp();
        app.contacts.add(new Contact("John Doe", "123456789", "john.doe@example.com"));
        app.listModel.addElement("John Doe");
        app.contactList.setSelectedIndex(0); // Simulating a selection

        // Act
        app.showContactDetails();

        // Assert
        assertEquals("Name: John Doe", app.nameLabel.getText());
        assertEquals("Phone: 123456789", app.phoneLabel.getText());
        assertEquals("Email: john.doe@example.com", app.emailLabel.getText());
    }

    // Testing the clearFormFields() method
    @Test
    public void ClearFormFields() {
        // Arrange
        ContactApp app = new ContactApp();
        app.nameField.setText("John Doe");
        app.phoneField.setText("123456789");
        app.emailField.setText("john.doe@example.com");

        // Act
        app.clearFormFields();

        // Assert
        assertEquals("", app.nameField.getText());
        assertEquals("", app.phoneField.getText());
        assertEquals("", app.emailField.getText());
    }

    // Testing the showCard() method
    // Testing the showCard() method
    @Test
    public void ShowCard() {
        // Arrange
        ContactApp app = new ContactApp();

        // Act
        app.showCard("DETAILS");

        // Assert
        assertNotNull(app.cardPanel); // Ensure cardPanel exists
    }




}





