import java.util.*; 
 
public class ContactManager { 
 
    public static void main(String[] args) { 
 
        HashMap<String, Contact> contacts = new HashMap<>(); 
 
        contacts.put("Emily P", new Contact("Emily P", "+1 934 056 7128"));
        contacts.put("Sally R", new Contact("Sally R", "+1 407 831 9738"));
        contacts.put("Fiona E", new Contact("Fiona E", "+1 398 483 2937"));
        contacts.put("Peter L", new Contact("Peter L", "+1 348 810 6328"));
        contacts.put("Billy A", new Contact("Billy A", "+1 710 837 2941"));

        ArrayList<String> testNames = new ArrayList<String>();
        testNames.add("Billy A");
        testNames.add("Dylan I");
        for (String name : testNames) {
            Contact contact = contacts.get(name);
            if (contact == null) {
                System.out.println("Contact not found");
            } else {
                System.out.println(contact.getName() + " | " + contact.getPhone());
            }
        }

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));  

        System.out.println("~~~~~~ All Contacts ~~~~~~");
        for (Contact contact : sorted) {
            System.out.println(contact.toString());
        }
    } 
}