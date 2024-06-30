import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("1234567890"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact("1234567890");
        assertNull(contactService.getContact("1234567890"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.updateContact("1234567890", "Jane", "Doe", "0987654321", "456 Elm St");
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Elm St", updatedContact.getAddress());
    }


}
