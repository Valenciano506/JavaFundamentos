package javaio;

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
		
	}

	private static void readFile() {		
		try {
			FileReader reader = new FileReader("log.txt");
			System.out.println((char)reader.read());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeFile() {
		try {
			FileWriter writer = new FileWriter("log.txt");
			writer.write("Black big dildo");
			writer.write("A Panblo le gusta el pene negro");
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
