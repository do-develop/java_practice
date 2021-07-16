package session3;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExternalizableExample implements Externalizable{

	private String userName;
	private String password;
	private Integer roll;
	
	public ExternalizableExample() {
		//A public no-arg constructor is required while using Externalizable interface.
	}
	
	public ExternalizableExample(String userName, String password, Integer roll) {
		this.userName = userName;
		this.password = password;
		this.roll = roll;
	}
	
	public static void main(String[] args) {
		try {
			ExternalizableExample ee = new ExternalizableExample("Juno","P@ssword",20);
			System.out.println(ee.toString());
			FileOutputStream fos = new FileOutputStream("temp.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(ee);
			oos.close();
			
			FileInputStream fis = new FileInputStream("temp.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			ExternalizableExample obj = (ExternalizableExample)ois.readObject();
			System.out.println(obj.toString());
		}catch(ClassNotFoundException | IOException ex) {
			Logger.getLogger(ExternalizableExample.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(userName);
		out.writeObject(roll);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		userName = (String)in.readObject();
		roll = (Integer)in.readObject();
		
	}

	public  String toString() {
		StringBuilder b = new StringBuilder();
	    b.append("userName: ");
	    b.append(userName);
	    b.append("  passWord: ");
	    b.append(password);
	    b.append("  roll: ");
	    b.append(roll);

	    return b.toString();
	}
}
