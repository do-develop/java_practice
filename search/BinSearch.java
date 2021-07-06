package search;
import java.util.Scanner;

public class BinSearch {
	
	static int binSearch(int[] a, int n, int key) {
		int leftIdx = 0; //
		int rightIdx = n-1;
		
		do {
			int midIdx = (leftIdx+rightIdx)/2;
			if(a[midIdx]==key)
				return midIdx;
			else if(a[midIdx]<key)
				leftIdx = midIdx+1;
			else
				rightIdx = midIdx-1;
		}while(leftIdx<=rightIdx);
		
		return -1;
	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("Element count: ");
		int num = stdIn.nextInt();
		int[] arrayX = new int[num];
		
		System.out.println("Enter values in ascending order");
		System.out.print("arrayX[0]: ");
		arrayX[0]=stdIn.nextInt();
		
		for(int i=1; i<num; i++) {
			do {
				System.out.print("arrayX["+i+"]:");
				arrayX[i] = stdIn.nextInt();
			}while(arrayX[i]<arrayX[i-1]); //check the value was entered in ascending order
		}
		
		System.out.print("Searching value: ");
		int key = stdIn.nextInt();
		
		int idx = binSearch(arrayX, num, key);
		
		if(idx==-1)
			System.out.println("Value not found in the array");
		else
			System.out.println(key+" value is in arrayX["+idx+"]");
	}

}
