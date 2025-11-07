package datastructure;

import java.util.Arrays;


public class MultiDimensionalArrayTest {
    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        int[][] world = new int[rows][columns];
        int[][] numbers =
                {
                        {1, 2, 345},
                        {23, 34, 2342},
                        {1, 2, 345},
                        {23, 34, 2342}
                };

        int[] arr = {2, 3434};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
            System.out.println(Arrays.toString(numbers[i]));
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.println(numbers[i][j] + "");
            }
            System.out.println();
        }
        //5,5,3
        int depth = 3;
        int[][][] minecraftWorld = new int[rows][columns][depth];
        for (int i = 0; i < minecraftWorld.length; i++) {
            for (int j = 0; j < minecraftWorld[i].length; j++) {
                for (int k = 0; k < minecraftWorld[i][j].length; k++) { //depth
                    minecraftWorld[i][j][k] = i + j + k;

                }
            }

        }
        System.out.println(minecraftWorld[0][0][0]);
        System.out.println(minecraftWorld[4][4][2]);


        System.out.println("The first depth");
        for (int i = 0; i < minecraftWorld.length; i++) {
            for (int j = 0; j < minecraftWorld[i].length; j++) {
                System.out.print(minecraftWorld[i][j][0] + " ");
            }
            System.out.println();
        }


        System.out.println("The second depth");
        for (int i = 0; i < minecraftWorld.length; i++) {
            for (int j = 0; j < minecraftWorld[i].length; j++) {
                System.out.print(minecraftWorld[i][j][1] + " ");
            }
        }

        System.out.println("The third depth");
        for (int i = 0; i < minecraftWorld.length; i++) {
            for (int j = 0; j < minecraftWorld[i].length; j++) {
                System.out.print(minecraftWorld[i][j][2] + " ");
            }
            System.out.println();
        }
        for (int k = 0; k < depth ; k++) {
            System.out.println("The third depth");
            for (int i = 0; i < minecraftWorld.length; i++) {
                for (int j = 0; j < minecraftWorld[i].length; j++) {
                    System.out.print(minecraftWorld[i][j][2] + " ");
                }
                System.out.println();
            }

        }

    }
}