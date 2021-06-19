package ws06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	int id;
	String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
}

public class SerializationExample {

	public static void main(String[] args) {
		
		Student s1 = new Student(111, "Evelyn");
		String fileName = "file.txt";
		
		//Serialization
		FileOutputStream fout;
		ObjectOutputStream oout;
		
		try {
			fout = new FileOutputStream(fileName);
			oout = new ObjectOutputStream(fout);

			oout.writeObject(s1);
			oout.flush();
			oout.close();
			
			System.out.println("The object is saved in a file: " + fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Deserialization
		FileInputStream fin;
		ObjectInputStream oin;
		Student s;
		try {
			fin = new FileInputStream(fileName);
			oin = new ObjectInputStream(fin);

			s = (Student)oin.readObject();

			System.out.println(s.id + " " + s.name);
			oin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
