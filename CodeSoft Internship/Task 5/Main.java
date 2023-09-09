import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equals(name));
    }

    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber, email);
                    addressBook.addContact(newContact);
                    break;
                case 2:
                    System.out.print("Enter the name of the contact to remove: ");
                    String contactToRemove = scanner.nextLine();
                    addressBook.removeContact(contactToRemove);
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to search for: ");
                    String contactToSearch = scanner.nextLine();
                    Contact foundContact = addressBook.searchContact(contactToSearch);
                    if (foundContact != null) {
                        System.out.println("Contact found:\n" + foundContact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 4:
                    List<Contact> allContacts = addressBook.getAllContacts();
                    if (allContacts.isEmpty()) {
                        System.out.println("No contacts in the address book.");
                    } else {
                        System.out.println("All Contacts:");
                        for (Contact contact : allContacts) {
                            System.out.println(contact + "\n");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Exiting Address Book.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}

