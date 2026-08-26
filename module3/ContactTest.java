package module3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import module3.Contact;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Aam M", "+1 483 712 4389");
    } 

    @Test
    void getName_nameSetCorrectly() {
        assertEquals("Aam M", contact.getName());
    } 
    
    @Test
    void getPhone_phoneSetCorrectly() {
        assertEquals("+1 483 712 4389", contact.getPhone());
    } 
    
    @Test
    void toString_containsBothFields() {
        assertTrue(contact.toString().contains("Aam M"));
        assertTrue(contact.toString().contains("+1 483 712 4389"));
    }

    @Test
    void toString_containsName() { 
        assertTrue(contact.toString().contains("Aam M"));
    } 
    
    @Test
    void toString_containsPhone() {
        assertTrue(contact.toString().contains("712 4389"));
    }

    @Test
    void bool_checkNullHandling() {
        HashMap<String, Contact> contacts = new HashMap<>(); 
        contacts.put(contact.getName(), contact);
        assertNull(contacts.get("Charlie X"));
    }
}
