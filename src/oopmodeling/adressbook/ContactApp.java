package oopmodeling.adressbook;

import java.util.Scanner;

/*
 * The class used to interact with the users
 *
 * @author Valenciano
 * 26 nov 2025
 */

public class ContactApp {
	
	final static AdressBook adressBook = new AdressBook();
	final static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		byte opcion = 4;
		while(true) {
			
			showMenu();
			opcion = scanner.nextByte();
			System.out.println("Has seleccionado la opción: " + opcion);
			
			if(opcion == 4) {
				System.out.println("Programa finalizado.");
				break;
			}
			
			else if(opcion == 1) {
				addContact();
			}
			
			else if(opcion == 2) {
				showContact();
			}
			
			else if(opcion == 3) {
				removeContact();
			}
			
		}

	}

	private static void addContact() {
		
		System.out.println("\n---Añade un contacto a la agenda---");
		
		//1. The user introduce the phone number, name and other information about the contact
		scanner.nextLine();
		System.out.print("Introduce el nombre del contacto: ");
		String nombre = scanner.nextLine();
		System.out.println(nombre);
		
		System.out.print("Introduce el apellido del contacto: ");
		String apellido = scanner.nextLine();
		System.out.println(apellido);
		
		System.out.print("Introduce el número de teléfono del contacto: ");
		String numero = scanner.nextLine();
		System.out.println(numero);
		
		System.out.print("Introduce el email del contacto: ");
		String email = scanner.nextLine();
		System.out.println(email);
		
		//2. Create an object of "Contact" encapsulating all the data passed in the first step
		Contact contact = new Contact(nombre, apellido, numero, email);
		
		//3. Add the new object to the contact array
		adressBook.addContact(contact);
		System.out.println("El contacto se ha añadido correctamente.");
	}
	
	private static void showContact() {
		adressBook.showContacts();
	}
	
	private static void removeContact() {
		
		System.out.println("\n---Elimina un contacto de la agenda---");
		
		//1. The user introduce the name of the contact that wants to remove
		scanner.nextLine();
		System.out.print("Introduce el nombre del contacto: ");
		String nombre = scanner.nextLine();
		System.out.println(nombre);
		adressBook.removeContact(nombre);
		System.out.println("Se ha eliminado correctamente el contacto " + nombre);
		
	}

	private static void showMenu() {
		
		System.out.println("\n===== MENÚ =====");
		System.out.println("1. Add contact");
		System.out.println("2. Show contacts");
		System.out.println("3. Remove contact");
		System.out.println("4. Exit");
		System.out.print("Select an option: ");
		
	}

}