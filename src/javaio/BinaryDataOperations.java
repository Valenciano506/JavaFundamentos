
package javaio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Write and read binary data to and from a file
 *
 * @author Valenciano
 * 14 ene 2026
 */

public class BinaryDataOperations {

	public static void main(String[] args) {
		
		writeBinaryData();
		readBinaryData();
		
	}

	private static void writeBinaryData() {
		
		//A variable with null initialization
				//DataOutputStream os = null;		
				try(DataOutputStream os = new DataOutputStream(new FileOutputStream("data.bat"))) {
					os.writeChar(25);
					os.writeInt(32);
					os.writeUTF("Pablo is Maricon");
					//os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	}

	private static void readBinaryData() {
	
		try (DataInputStream is = new DataInputStream(new FileInputStream(""))){
			is.readChar();
			is.readInt();
			is.readUTF();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
