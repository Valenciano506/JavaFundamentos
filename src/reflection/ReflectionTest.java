package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
		
		inspectClass(cls);
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
