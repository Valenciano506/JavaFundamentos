package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 *
 * @author Valenciano
 * 9 ene 2026
 */
public class FileUtil {
	
	public static void writeToFile(String content, String file) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file));){
			writer.write(content);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
