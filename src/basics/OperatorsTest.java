package basics;

public class OperatorsTest {
	
	public static void main(String[] args) {
		
		aritmeticOperationTest();
		unaryOperatorsTest();
		assigmentOperatorsTest();		
		
	}

	private static void assigmentOperatorsTest() {
		
		int number1 = 3;
		int number2 = 20;
		float result = number1 + number2;
		System.out.println(result);
		result += number1;
		System.out.println(result);
		result /= number1;
		System.out.println(result);
		
	}

	private static void unaryOperatorsTest() {
		
		int num1 = -234;
		num1++;
		System.out.println(num1);
		++num1;
		System.out.println(num1);
		System.out.println(num1++);		
		num1--;
		--num1;
		System.out.println(num1 == 234);
		System.out.println(!(num1 == 234));
		
	}

	private static void aritmeticOperationTest() {
		
		int num1, num2, num3;
		num1 = 456;
		System.out.println(num1);
		num2 = 628;
		System.out.println(num2);
		num3 = 949;
		System.out.println(num3);
		int result;
		result = num1 + num2;
		System.out.println("The result is " + result);
		result = result - num3;
		System.out.println("The result is " + result);
		result = result * 2;
		System.out.println("The result is " + result);
		result = result / 2;
		System.out.println("The result is " + result);
		result = result % 8;
		System.out.println("The modulus result is " + result);
	}
	
	

}
