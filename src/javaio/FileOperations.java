package javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 *
 * @author Valenciano
 * 3 dic 2025
 */
public class FileOperations {
	
	public static void main(String[] args) {
		
		File file = new File("/logs/user.log");
		File directory = new File("/manolo/logs/");
		System.out.println("Working directory: " + System.getProperty("user.dir"));
		
		createPath(directory);
		createFile(file);	
		createAbsolutePath();
		writeFile();
		readFile();
		bufferedRead();
		bufferedWrite();
		
	}

	private static void bufferedWrite() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("contacts.txt"));
			writer.write("Manolo" + ";" + " manu@G");
			writer.newLine();
			writer.write("Panblo" + ";" + " pab@G");
			writer.newLine();
			//writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void bufferedRead() {
		try {
			System.out.println("Buffered reader");
			BufferedReader br = new BufferedReader(new FileReader("log.txt"));
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	private static void readFile() {		
		try {
			FileReader reader = new FileReader("log.txt");
			//System.out.print((char)reader.read());
			
			//check the condition first before executing the while body
			int c;
			//System.out.println((char) -1 == -1);
			System.out.println("\n Primera lectura");
			//If we have read "-1", the loop finishes
			while ((c = reader.read()) != -1) {
				System.out.print((char)c);
			}		
			reader.close();
			
			reader = new FileReader("log.txt");
			System.out.println("\n \n Segunda lectura");
			//read a character from the file
			c = reader.read();
			while(c != -1) { //check if we have reached the end of the file
				//haven't reached the end
				System.out.print((char)c);
				c = reader.read();
			}
			reader.close();
			
			reader = new FileReader("log.txt");
			System.out.println("\n \n Tercera lectura");
			//Execute the commands inside the "do" body first, 
			//then check the condition if it is true, repeat 
			//the execution	
			c = 0;
			System.out.println("El valor de c es " + c);
			do {
				c = reader.read();
				System.out.print((char)c);
			}			
			while (c != -1);
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeFile() {
		try {
			FileWriter writer = new FileWriter("log.txt");
			writer.write("Black big dildo ");
			writer.write("A Panblo le gusta el pene negro ");
			writer.write('Y');
			//Close the writer and refresh the data to the file
			writer.close();
			//Refresh data we have written to the file
			//writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createAbsolutePath() {
		//create directory using absolute path
		File absoluteDir = new File(System.getProperty("user.dir") + "/logs/user.log");
		absoluteDir.mkdirs();
	}

	private static void createPath(File file) {
		
		System.out.println(file.isAbsolute());
		System.out.println(file.getPath());
		//create directories specified by the "file" object
		file.getParentFile().mkdirs();
		System.out.println(file.getAbsolutePath());
		
	}

	/*
	 * Create a file 
	 */
	
	private static void createFile(File file) {
		
		
		if(file.exists()) {
			System.out.println("The log file exists");
		}
		else {
			System.out.println("The log file does not exist");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//With try catch, we can continue executing the program without interruption
			System.out.println("Finshed");
		}
		
	}

}
