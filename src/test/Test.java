package test;

import oopmodeling.Star;

public class Test {public static void main(String[] args) {
	System.out.println("Panadería de pan");
	int num1 = 2001;
	int num2 = 2006;
	System.out.println("Panchitos Fuera");
	Star sunStar = new Star();
	Star marteStar = new Star();
	Planet marte= new Planet();
	Planet saturno= new Planet();
	
	//Cambiar la masa y nombre de una instancia de la clase estrella
	sun.setMass(23423);
	sun.setName("234")
	System.out.println("the mass of the sun is" + sun.getMass() );
	//java.lang.NullPointerException
	Star utus = null;
	System.out.println("the mass of the utus is" + utus.getMass() );
	
}
	
}
