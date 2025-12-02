package test;

import oopmodeling.Planet;
import oopmodeling.Star;

public class Test {public static void main(String[] args) {
	System.out.println(150);
	int num1 = 2005;
	int num2 = 2007;
	
	System.out.println(num1 + num2);
	Star sun = new Star();
	Planet mars = new Planet();
	Planet saturno = new Planet();
	Planet jupiter = new Planet();
	System.out.println(sun.mass);
	mars.setMass(324234);
	saturno.setName("planeta2");
	System.out.println("the name of the planet is " + saturno.getName());
	
	jupiter.setSize(1000);
	
	System.out.println("the size of the planet is " + jupiter.getSize());
	
	Star utus = null;
	//== Es el operador de comparación
	if (utus == null) {
		return;
	}
	
}
}
