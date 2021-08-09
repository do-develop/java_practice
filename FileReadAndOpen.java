import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileReadAndOpen {

	static String FILEPATH;
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter a file path for reading: ");
		FILEPATH = keyboard.nextLine();
		
		try {
			if(canRead(FILEPATH)) {
				System.out.println(FILEPATH + " can be opened for reading");
				System.out.println(FILEPATH + " character count: " + getCountOfCharacters(FILEPATH));
				System.out.println(FILEPATH + " word count: " + getCountOfWords(FILEPATH));
			}else {
				System.out.println(FILEPATH + " can't be opened");
			}
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	static Boolean canRead(String filepath) throws FileNotFoundException {
		boolean canread = false;
		File file = new File(FILEPATH);
		if(file.canRead())
			canread = true;
		
		return canread;
	}
	
	static int getCountOfCharacters(String filepath) throws IOException {
		int charCount = 0;
		String line = "";
		BufferedReader reader = getBufferedReader(filepath);
		
		while( (line = reader.readLine()) != null) {
			charCount += line.length();
		}
		
		return charCount;
	}
	
	static int getCountOfWords(String filepath) throws IOException {
		int wordCount = 0;
		String line = "";
		String[] words;
		BufferedReader reader = getBufferedReader(filepath);
		
		while( (line = reader.readLine()) != null ) {
			words = line.split(" ");
			wordCount += words.length;
		}
		
		return wordCount;
	}
	
	private static BufferedReader getBufferedReader(String filepath) throws FileNotFoundException {
		
		BufferedReader buff = new BufferedReader(
								new InputStreamReader(
									new FileInputStream(
											new File(filepath))));
		return buff;
	}
}
