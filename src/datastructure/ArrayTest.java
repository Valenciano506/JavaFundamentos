package datastructure;

import java.util.Random;

import oopmodeling.Planet;

public class ArrayTest {

	public static void main(String[] args) {
		String[] names = { "Pablo", "Juan", };
		Planet[] planets = { new Planet(), new Planet() };

		System.out.println(names[1]);

		sumup();

		int[] nums = new int[2000];
		initializeArray(nums);

		findMaxiMin();
		
		while (true) {
			break;
		}
	}

	private static void sumup() {
		// TODO Auto-generated method stub
		int[] scores = { 12, 34, 3423, 32 };
		System.out.println(scores[0]);// Access to the first element in the array
		System.out.println(scores[1]);// Retrieve the second element
		System.out.println(scores[2]);

		try {
			System.out.println(scores[3445]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			int total = scores[0] + scores[1] + scores[2];
			System.out.println("The total score is " + total);
			int totalScore = 0;
			for (int i = 0; i < scores.length; i++) {
				totalScore = totalScore + scores[i];
				System.out.println("totalScore = " + totalScore);
			}
			// Create an array with a capacity of storing 10000 integers
			int[] nums = new int[10000];
			System.out.println("the length of the number array is " + nums.length);

		}

	}

	private static void findMaxiMin() {
		// TODO Auto-generated method stub

	}

	private static void initializeArray(int[] nums) {
		Random random = new Random();
		// TODO Auto-generated method stub
		int len = nums.length;
		int j = 0;
		while (len > j) {

			nums[j] = random.nextInt(-10000, 10000000);
			j = j + 1; // This operation is the same as j++
		}

	}

}