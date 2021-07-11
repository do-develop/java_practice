package session2;

import java.util.Collection;
import java.util.HashSet;

public class StaticBindingTest {

	public static void main (String args[]) {
		Collection c = new HashSet();
		HashSet hs = new HashSet();
		StaticBindingTest test = new StaticBindingTest();
		test.sort(c);
		test.sort(hs);
	}
	
	public Collection sort (Collection c) {
		System.out.println("Inside Collection Sort Method");
		return c;
	}
	
	public Collection sort (HashSet hs) {
		System.out.println("Inside HashSet Sort Method");
		return hs;
	}
}
