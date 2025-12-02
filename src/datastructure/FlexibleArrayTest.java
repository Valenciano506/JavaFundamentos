package datastructure;

public class FlexibleArrayTest {

    public static void main(String[] args) {

        FlexibleArray<Integer> flexibleArray = new FlexibleArray<>(3);
        System.out.println("The current size = " + flexibleArray.size());
      
        for (int i = 0; i < 5; i++) {
        	  flexibleArray.add(3 + i);
		}
        
        System.out.println("The current size = " + flexibleArray.size());
        flexibleArray.remove(1);
        flexibleArray.remove(1);

    }

}
