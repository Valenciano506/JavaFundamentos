package oopmodeling.adressbook;
import datastructure.FlexibleArray;

/*
 * This class is used to manage a list of contacts objects
 *
 * @author Valenciano
 * 26 nov 2025
 */

public class AdressBook {
	
	//Attributes
	//This is the container for the list of contact objects
	protected FlexibleArray<Contact> contacts;
	
	public AdressBook() {
		contacts = new FlexibleArray<Contact>();
	}
	
	//Behaves
	public void showContacts() {
		
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public boolean removeContact(String name) {
		//1. A loop to find the position of the contact
		//Contact[] eles = contacts.getAll();
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equals(name)) {
				contacts.remove(i);
				return true;
			}
		}
		//2. Remove the contact by its position in the array
		
		contacts.remove(0);
		return false;
	}

}
