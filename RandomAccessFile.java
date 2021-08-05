package lab3_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Q7_RandomAccessFile {

	static final String FILEPATH = "numbers.dat";
	
	public static void main(String[] args) {
		try {
			RandomAccessFile file = new RandomAccessFile(FILEPATH, "rw");
			file.seek(0);
			for(int i=1; i<=100; ++i) {
				file.writeInt(i);
			}
			
			//print the second integer
			file.seek(1*4); //one integer is 4 bytes long
			System.out.println(file.readInt());
			
			//print every 10th number
			file.seek(0); //go to the first location
			int number;
			long fileSize = file.length();
			for(int i=9; i<=100; i+=10) {
				file.seek(i*4);
				number = file.readInt();
				System.out.printf("Number %d: %d\n", i+1, number);
			}
			
			System.out.println("Length of the file: "+fileSize);
			
		} catch (FileNotFoundException ferr) {
			ferr.printStackTrace();
		} catch (IOException ioerr) {
			ioerr.printStackTrace();
		}
		

	}

}
