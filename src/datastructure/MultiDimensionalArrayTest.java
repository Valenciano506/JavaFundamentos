package datastructure;

import java.util.Arrays;

public class MultiDimensionalArrayTest {
	
	public static void main(String[] args) {
		
		int rows = 10;
		int columns = 30;
		int[][] world = new int[rows][columns];
		
		int[][] numbers =
			{
					{1, 2, 345},
					{23, 34, 2342},
					{1, 43, 4},
					{23, 5, 56}
			};
		
		int[] arr = {2, 3434, 234, 2};
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
			System.out.println(Arrays.toString(numbers[i]));
			for (int j = 0; j < numbers[i].length; j++) {
				System.out.println(numbers[i][j] + " ");
			}
			System.out.println();
		}
			
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(world[i][j] + " ");
			}
		}
		
		int depth = 2;
		int[][][] minecraftWorld = new int [rows][columns][depth];
		for (int i = 0; i < minecraftWorld.length; i++) {
			for (int j = 0; j < minecraftWorld[i].length; j++) {
				for (int k = 0; k < minecraftWorld[i][j].length; k++) {
					System.out.print(minecraftWorld[i][j][k] + "-");
				}
			}
		}
		
	}

}
