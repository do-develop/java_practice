package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class DeserialiseTest implements Serializable {

	public static void main(String[] args) {
		
		User user = null;
		try {
			FileInputStream fileIn = new FileInputStream("UserInfo.ser");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			user = (User)objIn.readObject();
			//close all io objects
			objIn.close();
			fileIn.close();
			//print deserialised object
			System.out.println("User name: "+user.name);
			System.out.println("User password: "+user.password);
			user.sayHello();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
