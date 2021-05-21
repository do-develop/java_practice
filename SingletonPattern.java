package singletonExample;

//final class
final class Singleton{
	private static Singleton s = new Singleton(47);
	private int i;
	
	//make constructor private
	private Singleton(int x) { 
		i = x; 
	}
	
	public static Singleton getReference() {
		return s;
	}

	public int getValue() {
		return i;
	}
	
	public void setValue(int x) {
		i = x;
	}
}
public class SingletonPattern {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getReference();
		System.out.println(s1.getValue());
		
		//singleton works like a global variable
		Singleton s2 = Singleton.getReference();
		s2.setValue(9);
		System.out.println(s1.getValue());
		
		//can't make a clone
		/*
		try {
			Singleton s3 = (Singleton)s2.clone(); //not visible
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
