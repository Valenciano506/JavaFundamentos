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
    private static final int EXPANSION_FACTOR = 40;
    public FlexibleArray(int size){
    	if(size <= 0) {
    		size = INITIAL_CAPACITY;
    	}
    	//create an array of objects
        elements = (T[]) new Object[size];
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
    	if(size == elements.length) {//The array is full, we have to extend its capacity    		
    		//First, we create a new array with mayor capacity
    		T[] newArr = (T[])new Object[elements.length + EXPANSION_FACTOR];
    		// copy the elements from the old array to the new one
    		//newArr[0] = elements[1]
    		//newArr[0] = elements[1]
    		for(int i = 0; i < elements.length; i++) {
    			newArr[i] = elements[i];
    		}
    		elements = newArr;
    	}
        //paso 1: add the element to the last position of the array
    	elements[size] = e;
    	size++;
        //paso 2:
    }

    /*
    Remove the element at position "i"
     */

    public void remove(int i) {
    	//Step 1: eliminate the element at position passed by the parameter
    	elements[i] = null;
    	//Step 2: move all the elements behind the eliminated element one step to the left
//    	elements[i] = elements[i + 1];
//    	elements[i + 1] = elements[i + 2];
//    	elements[i + 2] = elements[i + 3];
//    	elements[i + 3] = elements[i + 4];
    	//...
    	
    	//size - i - 1 is the number of elements that we have to move
    	for (int j = 0; j < size - i -1; j++) {
			elements[i + j] = elements[i + j + 1];
		}
    	
    	size--;
    }

    public int size() {
        return size;
    }
    
    public T get(int index) {
    	return elements[index];
    }
    
}
