package recursion;
import java.util.Scanner;

public class Factorial {
	
	static int factorial(int n) {
		if(n>0)
			return n*factorial(n-1);
		else
			return 1;
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.print("Enter natural number:");
		int num = read.nextInt();
		
		System.out.println("The facorial value of "+num+" is "+factorial(num));

	}

}
