package lab2_1;

import java.util.Scanner;

public class GetNumber {

	static Scanner keyboard = new Scanner(System.in);
	static int numberInput = 0;
	static int count = 0;
	static int[] numbers = new int[100];
	public static void main(String[] args) {

		getNumber();
		while(numberInput >= 0 && count < 100) {
			getNumber();
		}
		
		displayNumbers();
		double avg = getAverage();
		System.out.println("Average: "+ avg);
		getCountAverage(avg);
		
	}

	public static void getNumber() {
		System.out.print("Enter a postive number: ");		
		numberInput = keyboard.nextInt();
		if(numberInput >= 0)
			numbers[count++] = numberInput;
	}
	
	public static double getAverage() {
		int total=0;
		double average=0;
		
		for(int i=0; i<count; ++i) {
			total += numbers[i];
		}
		average = (double)total/count;
		
		return average;
	}

	public static void getCountAverage(double average) {
		int greaterCount=0;
		int smallerCount=0;
		for(int i=0; i<count; ++i) {
			if(numbers[i]> average)
				greaterCount++;
			else
				smallerCount++;
		}
		System.out.println("Count numbers greater than average: "+greaterCount);
		System.out.println("Count numbers smaller than average: "+smallerCount);
	}
	
	public static void displayNumbers() {
		for(int i=0; i<count; ++i) {
			System.out.print(numbers[i]+" ");
			if(i!=0 && (i+1)%4==0)
				System.out.println();
		}
		System.out.println();
	}
	

}

