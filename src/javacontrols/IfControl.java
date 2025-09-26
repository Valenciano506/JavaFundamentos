package javacontrols;

public class IfControl {
	
	public static void main(String[] args) {
		int num1 = 1;
		int num2;
		num2 = 34;
		int result;
		result = num1 - num2;
		System.out.println(result);
		
		if(result > 0) {
			System.out.println("number 1 is greater than number2");
		}
		
		else {
			System.out.println("number 1 is less than number 2");
		}
	}

}
