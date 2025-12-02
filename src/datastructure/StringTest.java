package datastructure;

import java.util.Arrays;

/*
 * La tarea consiste en reemplazar los "?" por otro valor
 * "select * from user where username = ? and email = ?"
 */

public class StringTest {
	
	public static void main(String[] args) {
		
		String querySQL = 
				"select * from user where username = 'Manolo' and email = 'manolo@gmail.com' ";
		querySQL = 
				"select * from user where username = ? and email = ?";
		
	String[] params = {"Manolo", "manolito@gmail.com"};
		
		System.out.println(sqlProcess(params, querySQL));		
		
	}
	
	private static String sqlProcess(String[] parameters, String SQL) {
		
		int i = 0;		
		
		char[] characters = SQL.toCharArray();
		String sum = "";
		
		for (char character : characters) {
			//System.out.println("The current character is " + character);
			//Relational operator of inequality is "!=" "no igual"
			if (character != '?') {
				sum += character;
			}
			else {//character == '?'
				sum += parameters[i];
				i++;
			}
			
		}
		
		System.out.println("The new string is " + sum);
		System.out.println("Sub string " + SQL.subSequence(0, 10));
		System.out.println("Replace all ? with the value passed through the username variable " + SQL.replace("?", "username"));
		System.out.println(Arrays.toString(characters));
		System.out.println(SQL.indexOf("?"));
		System.out.println(SQL.charAt(36));
		
		return sum;
		
	}

}
