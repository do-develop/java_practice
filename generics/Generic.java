package generics;

public class Generic {

	public static void main(String[] args) {
		/*
		Integer[] integerArray = {1, 2, 3, 4, 5};
		Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
		Character[] characterArray = {'J','A','V','A'};
		String[] stringArray = {"Hi","Generic"};
		
		displayArray(integerArray);
		displayArray(doubleArray);
		displayArray(characterArray);
		displayArray(stringArray);
		
		System.out.println(firstElement(integerArray));
		System.out.println(firstElement(doubleArray));
		System.out.println(firstElement(characterArray));
		System.out.println(firstElement(stringArray));
		*/
		
		GenericClass<Integer, Integer> myInt = new GenericClass<>(1,2);
		GenericClass<Integer, Double> myDouble = new GenericClass<>(3,1.01);
		//GenericClass<Character, Character> myChar = new GenericClass<>('A','B');
		//GenericClass<String, Character> myString = new GenericClass<>("Hello", '!');
		
		System.out.println(myInt.getValue());
		System.out.println(myDouble.getValue());
		//System.out.println(myChar.getValue());
		//System.out.println(myString.getValue());
		
	}
	//Generic method
	public static <Type> void displayArray(Type[] array) {
		for(Type x : array) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public static <Type> Type firstElement(Type[] array) {
		return array[0];
	}
}
