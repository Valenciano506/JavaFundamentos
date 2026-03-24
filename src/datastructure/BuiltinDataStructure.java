package datastructure;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import oopmodeling.Planet;
/*
 * @author Valenciano
 * 23 mar 2026
 */
public class BuiltinDataStructure {
	
	public static void main(String[] args) {
		//Create two objects of class {@link Planet}
		Planet planet1 = new Planet();
		Planet planet2 = new Planet(123, "Mars");
		//Create an object of array with a fixed size of 5
		Planet[] pls = new Planet[5];
		pls[0] = planet1;
		pls[1] = planet2;
		//Create an object of class {@link ArrayList}
		ArrayList<Planet> planets = new ArrayList<>();
		//Add an object to position 0
		planets.add(planet1);
		//Add an object to position 1
		planets.add(planet2);
		//Retrieve the value at position at index 1
		planets.get(1);
		//Create an object of class {@link LinkedList} and add some objects of String
		LinkedList<String> names = new LinkedList<>();
		names.add("Pablo");
		names.add("Justo");
		//Less efficient than accessing elements in an Array when using index
		names.get(1);
		Stack<Integer> callstack = new Stack<>();
		//Add an element on the top of the stack
		callstack.push(34);
		callstack.push(10);
		callstack.push(2);
		//Peek method is used to read the element on top of the stack without eliminating it
		System.out.println(callstack.peek());
	}

}
