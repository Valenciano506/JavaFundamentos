package datastructure;

/*
This is a class that represent an extensible array.
An array has a fixed capacity, when reaching the end
of the array, we have to expand it.
 */

public class FlexibleArray<T>{
    /*
    We use this constructor to create an array when
    we know how many elements to store in the array
     */
    //An array with fixed size
    private T[] elements;
    private final int INITIAL_CAPACITY = 5;

    //The variable to store how many elements we have added to the array
    private int size = 0;
    public FlexibleArray(int size){
        elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    /*
    Use this constructor to create an array with a default capacity
     */
    public FlexibleArray(){
        elements = (T[]) new Object[INITIAL_CAPACITY];
    }

    /*
    Add an element to the array at its last position
     */

    public void add(T e) {
        //paso 0: check if we have reached to the last position,
        //if true, we have to expand the capacity of the array
        //paso 1: add the element to the last position of the array
        //paso 2:
    }

    /*
    Remove the element at position "i"
     */

    public void remove(int i) {
    }

    public int size() {
        return 0;
    }
}
