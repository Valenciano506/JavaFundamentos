package datastructure;

import java.util.Arrays;

public class SortingTest {

    //In this algorithm, we search a specific element in an ordered array
    // by comparing the element with the ones in the array one by one.
    //The time consumed in this algorithm is proportional to the size of the array.

    public static void main(String[] args) {
        String[] names = {"Pablo", "Juan", "Ana", "Justo", "Ruben"};
        //[2, 2, 3, 12, 20, 34, 1000, 3423]
        int[] scores = {12, 1000, 3423, 34, 2, 20, 3, 2};
        sort(scores);
        System.out.println("Ordered array " +  Arrays.toString(scores));

        boolean isExisting = busquedabinaria(3, scores);
        System.out.println(isExisting);

        isExisting = busquedalineal(3, scores);
        System.out.println("Búsqueda lineal " + isExisting);
    }

    private static boolean busquedalineal(int elemento, int[] elementos) {

        //Steps:
        //1. Create a loop to traverse the elements in the array
        //2. In the body of the loop, we compare the element with the elements
        //of the array, if there is a match, we return true.

        for (int i = 0; i < elementos.length; i++) {
            if(elementos[i] == elemento);
            return true;
        }

        return false;
    }

    private static boolean busquedabinaria(int elemento, int[] elementos) {

        //1. Calculate the index of the middle element
        int startIndex = 0;
        int endIndex = elementos.length;
        int middleIndex = (endIndex - startIndex) / 2;
        //2. If the middle element is equal to the element we are looking for, return true
        if(elementos[middleIndex] == elemento){
            return true;
        }
        //3. If the current element in the array is greater, we check left half
        else if(elementos[middleIndex] > elemento){
            endIndex = middleIndex;
            middleIndex = (endIndex - startIndex) / 2;
        }
        //4. If the current element in the array is smaller, we check right half
        else{//elementos[middleIndex] < elemento

        }

        return false;
    }



    private static void sort(int[] arr) {

        int j = 0;

//*  for (int i = 0; i < arr.length - 1 - j; i++) {
//			 int previous = arr[i];
//			 int next = arr[i + 1];
//			 if(previous > next) {
//
//				 ArrayTest.switchValues(arr, i, i + 1);
//				 System.out.println(Arrays.toString(arr));
//			 }
//		 }
//		 j++;
//
//		 for (int i = 0; i < arr.length - 1 - j; i++) {
//			 int previous = arr[i];
//			 int next = arr[i + 1];
//			 if(previous > next) {
//
//				 ArrayTest.switchValues(arr, i, i + 1);
//				 System.out.println(Arrays.toString(arr));
//			 }
//		 }
//		 j++;
//
//		 for (int i = 0; i < arr.length - 1 - j; i++) {
//			 int previous = arr[i];
//			 int next = arr[i + 1];
//			 if(previous > next) {
//
//				 ArrayTest.switchValues(arr, i, i + 1);
//				 System.out.println(Arrays.toString(arr));
//			 }
//		 }
//		 j++;

        while (j < arr.length) {
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