package javacontrols;

public class IfControl {
	
	public static void main(String[] args) {
		int num1 = 1;
		int num2;
		num2 = 34;
		int result;
		result = num1 - num2;
		System.out.println(result);
		
		/*
		 * The number stored in "result" can be any integer,
		 * but the following program includes all possibilities
		 */
		
		/*
		 * The following two code snippet give us the same result, 
		 * but the control flow is different, in the first one,
		 * only one of the ifs will be executed, but in the second one,
		 * all ifs will be checked
		 */
		
		if(result > 0) {
			System.out.println("number 1 is greater than number2");
		}
		
		else if (result == 0){
			System.out.println("number 1 is equal number 2");
		}
		
		else {
			System.out.println("number 1 is less than number 2");
		}
		
		if(result > 0) {
			System.out.println("number 1 is greater than number2");
		}
		
		if (result == 0){
			System.out.println("number 1 is equal number 2");
		}
		
		if (result < 0) {
			System.out.println("number 1 is less than number 2");
		}
		
	}

}
