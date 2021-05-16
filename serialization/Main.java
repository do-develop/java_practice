package serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

public class Main {

	public static void main(String[] args) {
		
		User user = new User();
		
		user.name = "Magie";
		user.password = "pa$$w0rd123";
		
		try {
			FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(user);
			
			//close all io stream objects
			objOut.close();
			fileOut.close();
			System.out.println("Object info is saved.");
			
			//get serial version uid
			long serialVersionUID = 
					ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
			System.out.println(serialVersionUID);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
