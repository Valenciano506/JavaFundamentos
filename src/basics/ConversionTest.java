package basics;

import oopmodeling.CelestialBody;
import oopmodeling.Planet;
import oopmodeling.Star;

/*
 * 
 *
 * @author Valenciano
 * 21 nov 2025
 */

public class ConversionTest{
	
	public static void main(String[] args) {		
		
		primitiveConversion();
		objectConversion();
		
	}
	
	private static void objectConversion() {
		
		//Polymorphism
				Planet p1 = new Planet();
				//A planet is not a star, we cannot assign a planet object to a star object
		        //Star s1 = (Star) new Planet();
				//In the following two cases, a planet is of type CelestialBody and Object
				CelestialBody p2 = new Planet();
				Object p3 = new Planet();
				Object p4 = new CelestialBody();
				Planet p5 = (Planet) p3;
				System.out.println(p5);
				System.out.println(p3);
				System.out.println(p5 == p3);
				Object[] planets = new Object[20];
				Planet[] pls = (Planet[]) planets;
				/*
				 * 1. Create an array of Object of size 20
				 * 2. Assign each position of the array with an object of type Planet (using for loop)
				 * 3. Convert the whole array explicitly to an array of Planet
				 */
				
				Object[] objs = new Object[20];
				for (int i = 0; i < objs.length; i++) {
					objs[i] =  new Planet();
				}
				//After the conversion of the objects, now we can use the methods of "Planet"
				Planet[] ps = (Planet[]) objs;
				ps[0].getName();
				
				polymorphismMethod(p2);
				polymorphismMethod(objs[0]);
		
	}
	
	private static void polymorphismMethod(Object cb) {
		
		//an algorithm that processes an object of CelestialBody type
		
	}
	
	private static void primitiveConversion() {
		
		int num1 = 200;
		byte num2 = 127;
		float num3 = 324.4f;
		double num4 = 34;
		num1 = num2;
		System.out.println(num1);
		num1 = 129;
		System.out.println(num1);
		//explicit conversion from an integer to a byte number
		num2 = (byte) num1;
		System.out.println("El número 2 es: " + num2);
		//Even explicitly we can not and should not cast an int array to a byte array nor the contrary
		//because the process is complicated to do and not so useful
		int[] nums1 = new int[23];
		byte[] nums2 = new byte[23];
//		nums1 = (int[]) nums2;
//		nums2 = (byte[]) nums1;
		
	}

}
