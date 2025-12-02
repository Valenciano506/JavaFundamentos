package datastructure;

import java.util.Arrays;
import java.util.Random;


import oopmodeling.Planet;

/*
 *Comments about advantages and disadvantages of an array 
 */

public class ArrayTest {

	public static void main(String[] args) {
		String[] names = { "Pablo", "Juan"};
		System.out.println(names);
		Planet[] planet = { new Planet(), new Planet() };
		int[] numeros1 = {47, 50, 37, 85};
		int[] patatas = {67, 83, 29, 42};

		System.out.println(names[1]);
		System.out.println(planet[1]);

		sumup();

		int[] nums = new int[2000];
		initializeArray(nums);

		findMaxiMin();
		switchvalues(numeros1, 1, 3);
		System.out.println(Arrays.toString(numeros1));		
		incrementSalary();
		reverse(numeros1);
		
		int[] sliced = slice(patatas, 1, 2);
		System.out.println(Arrays.toString(sliced));
		
		while (true) {
			break;
		}
		
		
		
	}
	
	/*
	 * @param arr 
	 * @param start
	 * @param end
	 * @return
	 */

	private static int[] slice(int[] arr, int start, int end) {
		
		if(arr == null) {
			return null;
		}
		
		if(start < 0 || end < 0 || start >= arr.length || end >= arr.length) {
			return null;
		}
		
		if(start > end) {
			return null;
		}
		
		System.out.println(arr);
		int[] result = new int[end - start + 1];
		//result[0] = arr[start];
		//result[1] = arr[start + 1];
		//result[2] = arr[start + 2];
		for (int i = 0; i < result.length; i++) {
			result[i] = arr[start + i];
	}
		return result;
		
	}

	private static void reverse(int[] arr) {
		
		/*
		 * Reverse the other of the elements in the array
		 * the array that we are going to reverse
		 * 
		 */
		
		
		int index1 = 0;
		int index2 = arr.length -1;
		
		for (int i = 0; i < arr.length / 2; i++) {
			
			int dato = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = dato;
			index1++;
			index2--;
			System.out.println(Arrays.toString(arr));
			
		}
		
		
		
	}

	private static void incrementSalary() {
		
		float[] salaries = {1263.87f, 8976.46f, 3784.96f};
		salaries[0] = salaries[0] + 10;
		System.out.println("El salario es " + salaries[0]);
		salaries[1] = salaries[1] + 10;
		System.out.println("El salario es " + salaries[1]);
		salaries[2] = salaries[2] + 10;
		System.out.println("El salario es " + salaries[2]);
		
		for (int i = 0; i < salaries.length; i++);
		
	}

	public static void switchvalues(int[] arr, int index1, int index2) {

        if(arr == null) {
            return;
        }
        // >= means greater or equal
        //The index of the last element in an array is arr.lenght -1
        if(index1 >= arr.length|| index2 >= arr.length) {
            return;
        }
        //if(arr.length)
        int dato= arr [index1];
        arr[index1] = arr[index2];
        arr[index2] = dato;


    }

	private static void sumup() {
		int[] scores = { 12, 34, 3423, 32 };
		System.out.println(scores[0]);// Access to the first element in the array
		System.out.println(scores[1]);// Retrieve the second element
		System.out.println(scores[2]);

		try {
			System.out.println(scores[3445]);
		} catch (Exception e) {
			e.printStackTrace();

			int total = scores[0] + scores[1] + scores[2];
			System.out.println("The total score is " + total);
			int totalScore = 0;
			for (int i = 0; i < scores.length; i++) {
				totalScore = totalScore + scores[i];
				System.out.println("TotalScore = " + totalScore);
			}
			// Create an array with a capacity of storing 10000 integers
			int[] nums = new int[10000];
			System.out.println("The length of the number array is " + nums.length);

		}

	}

	private static void findMaxiMin() {

	}

	private static void initializeArray(int[] nums) {
		Random random = new Random();
		int len = nums.length;
		int j = 0;
		while (len > j) {

			nums[j] = random.nextInt(-10000, 10000000);
			j = j + 1; // This operation is the same as j++
		}

	}

}