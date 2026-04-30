package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import oopmodeling.adressbook.AdressBook;

/*
 *
 * @author Valenciano
 * 27 abr 2026
 */
public class ReflectionTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		//To load 
		Class<AdressBook> cls = AdressBook.class;
		Class<AdressBook> cls2 = (Class<AdressBook>) new AdressBook().getClass();
		Class<?> cls3 = Class.forName("oopmodeling.adressbook.AdressBook");
		
		inspectClass(cls);
		
		AdressBook adressBook = new AdressBook();
		manipulateObject(adressBook);
		
		invokeMethodOfAnObject(adressBook);
		
	}

	private static void invokeMethodOfAnObject(Object obj) {
		
		Class<?> cls = obj.getClass();
		try {
			Method method = cls.getDeclaredMethod("addContact", String.class);
			method.invoke(obj, null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private static void manipulateObject(AdressBook adressBook) {
		
		Class<?> cls = adressBook.getClass();
		Field[] fields = cls.getDeclaredFields();
		try {
			//Potentially we may get a no such field exception
			//We pass a filed name that does not exist
			Field field = cls.getDeclaredField("Contact");
			System.out.println();
			//Change the access modifier from private to public
			field.setAccessible(true);
			//Read the value of a specified field
			System.out.println(field.get(adressBook));			
			//Modify the value of a field of the object
			field.set(adressBook, "12345");
			System.out.println(field.get(adressBook));
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private static void inspectClass(Class<AdressBook> cls) {

		cls.getDeclaredConstructors();
		Method[] ms = cls.getDeclaredMethods();
		for (int i = 0; i < ms.length; i++) {
			System.out.println("Method name is " + ms[i].getName());
			System.out.println("Method type is " + ms[i].getParameters());
		}

		for(Field field : cls.getDeclaredFields()) {
			System.out.println("Field name is " + field.getName());
			System.out.println("Field type is " + field.getType());
		}

		for(Annotation annotation : cls.getAnnotations()) {
			System.out.println("Annoation type is " + annotation.annotationType());
		}
		
	}

}
