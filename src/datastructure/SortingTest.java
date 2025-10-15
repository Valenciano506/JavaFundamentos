package datastructure;

import java.util.Arrays;

public class SortingTest {
	
	public static void main(String[] args) {
		
		String[] names = {"Pablo", "Juan", "Ana", "Justo", "Ruben"};
		int[] scores = {666666, 333, 7777777, 22, 88888888, 1, 55555, 4444};
		
		sort(scores);
		
	}

	private static void sort(int[] arr) {
		
		int j = 0;
		
//		for (int i = 0; i < arr.length - 1 - j; i++) {
//			int previous = arr[i];
//			int next = arr[i + 1];
//			if (previous > next) {
//				
//				ArrayTest.switchvalues(arr, i, i + 1);
//				
//				System.out.println(Arrays.toString(arr));
//				
//			}
//		}
//		
//		j++;
//		
//		for (int i = 0; i < arr.length - 1 - j; i++) {
//			int previous = arr[i];
//			int next = arr[i + 1];
//			if (previous > next) {
//				
//				ArrayTest.switchvalues(arr, i, i + 1);
//				
//				System.out.println(Arrays.toString(arr));
//				
//			}
//		}
//		
//		j++;
//		
//		for (int i = 0; i < arr.length - 1 - j; i++) {
//			int previous = arr[i];
//			int next = arr[i + 1];
//			if (previous > next) {
//				
//				ArrayTest.switchvalues(arr, i, i + 1);
//				
//				System.out.println(Arrays.toString(arr));
//				
//			}
//		}
//		
//		j++;
		
		while(j < arr.length) {
			
			System.out.println("La última posición es " + (arr.length - 1 - j));
			
			for (int i = 0; i < arr.length - 1 - j; i++) {
				int previous = arr[i];
				int next = arr[i + 1];
				if (previous > next) {
					
					ArrayTest.switchvalues(arr, i, i + 1);
					
					System.out.println(Arrays.toString(arr));
					
				}
			}
			
			j++;
			
		}
		
	}

}
