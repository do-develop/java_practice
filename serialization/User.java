package serialization;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1;
	String name;
	transient String password; //this is not serialisable
	
	public void sayHello() {
		System.out.println("Hello "+name);
	}
}
