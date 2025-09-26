package javacontrols;

public class LoopControls {
	
	public static void main(String[] args) {
		System.out.println(args.length);
		int num = 0;
		for (int i = 0; i < 3; i++) {
			System.out.println(i);
			
			num++;
		}
		
		System.out.println("the value of the number variable is " + num);
		int j = 0;
		while (j < 10) {
			System.out.println("the value of j is " + j);
			
			j++;			
		}
		System.out.println("the value of j is " + j);
	}

}
