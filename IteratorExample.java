package session3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {

	private int number;
	public IteratorExample(int i) {
		number = i;
	}
	public void displayNumber() {
		System.out.println("Number: "+number);
	}
	public static void main(String[] args) {
		List myNumber = new ArrayList();
		
		for(int i=1; i<=10; ++i)
			myNumber.add(new IteratorExample(i));

		Iterator it = myNumber.iterator();
		
		while(it.hasNext())
			((IteratorExample)it.next()).displayNumber();
	}

}
