package basics;

import java.util.Arrays;

public class GenericMethods {

	public static void main(String[] args) {
		
		String[] names = {"Pablo", "Juan", "Ana", "Justo", "Ruben"};
		Integer[] scores = {666666, 333, 7777777, 22, 88888888, 1, 55555, 4444};
		switchvalues(names, 0, 1);
		switchvalues(scores, 0, 1);
		System.out.println(Arrays.toString(names));
		System.out.println(Arrays.toString(scores));
		
	}
	
	/*
	 * We can create generic methods to reach its maximum reusability of the code of a method
	 * <Element> The name of the generic type
	 */
	
public static <Element> void switchvalues(Element[] arr, int index1, int index2) {
		
		if(arr == null) {
			return;
		}	
		if(index1 < 0 || index2 < 0) {
			return;
		}
		
		if(index1 >= arr.length || index2 >= arr.length) {
			 
		}
		
		Element dato = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = dato;
		
	}
	
}
