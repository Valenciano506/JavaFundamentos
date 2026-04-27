package reflection;

import oopmodeling.adressbook.AdressBook;

/*
 *
 * @author Valenciano
 * 27 abr 2026
 */
public class ReflectionTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<AdressBook> cls = AdressBook.class;
		Class<AdressBook> cls2 = (Class<AdressBook>) new AdressBook().getClass();
		Class<?> cls3 = Class.forName("oopmodeling.adressbook.AdressBook");
	}

}
