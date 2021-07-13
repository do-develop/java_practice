package session2;

public class PassArray {

	public static void main(String[] args) {
		int array[] = {1, 2, 3, 4, 5};
		
		System.out.println(
				"Effect of passing reference to entire array:\n"
				+"The value of the original array are:");

		//output original array elements
		for(int value : array)
			System.out.printf(" %d", value);
		
		modifyArray(array); //pass array reference
		System.out.println( "\n\nThe values of the modified array are:");

	    // output modified array elements 
	    for (int value : array)
	    	System.out.printf( " %d", value );
	    
	    System.out.printf(
	    		"\n\nEffects of passing array element value:\n" +
	            "array[3] before modifyElement: %d\n", array[3]);
	    
	    modifyElement(array[3]);
	    System.out.printf( 
	            "array[3] after modifyElement: %d\n", array[3]);
	}

	public static void modifyArray(int array[]) {
		for(int cnt=0; cnt< array.length; cnt++)
			array[cnt] *= 2;
	}
	
	public static void modifyElement(int element) {
		element *= 2;
		System.out.printf( 
		         "Value of element in modifyElement: %d\n", element );
	}
}
