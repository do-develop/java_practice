package javafx_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


class Programmer implements Cloneable{
	
	private static final Logger LOG = Logger.getLogger("CloneTest");
	private String name;
	private int age;
	private List certifications;
	
	public Programmer(String name, int age) { 
		this.name = name; 
		this.age = age; 
		this.certifications = new ArrayList(); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addCertifications(String certs) {
		certifications.add(certs);
	}

	@Override public String toString() { 
		return String.format("%s, %d, Certifications: %s", 
							name, age, certifications.toString());
	}

	@Override
	protected Programmer clone() {
		Programmer clone = null;
		try {
			clone = (Programmer) super.clone();
			clone.certifications = new ArrayList(certifications);
		}catch(CloneNotSupportedException error) {
			LOG.log(Level.WARNING, error.toString());
		}
		return clone;
	}
	
}

public class CloneTest {

	private static final Logger LOG = Logger.getLogger("CloneTest");
	
	public static void main(String[] args) {
		LOG.setLevel(Level.INFO);
		
		Programmer coder = new Programmer("Milk", 100);
		coder.addCertifications("PMP");
		coder.addCertifications("CISM");
		coder.addCertifications("OCPJP");
		coder.addCertifications("OCMJD");
		
		Programmer clone = coder.clone();
		System.out.println("Original Programmer: "+coder);	
		System.out.println("Clone of Programmer: "+clone);
		
		coder.addCertifications("Oracle DBA");
		System.out.println("Original Programmer: "+coder);	
		System.out.println("Clone of Programmer: "+clone);

	}

}
