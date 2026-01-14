
package javaio;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 
 *
 * @author Valenciano
 * 14 ene 2026
 */

public class BinaryDataOperations {

	public static void main(String[] args) {
		//A variable with null initialization
		//DataOutputStream os = null;		
		try {
			DataOutputStream os = new DataOutputStream(new FileOutputStream(""));
			os.writeChar(34);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
