package search;
import java.util.Scanner;
/*sequential search method with the use of a sentinel*/
public class SeqSearch {
	
	static int seqSearch(int[]a, int n, int key) {
		int i=0;
		
		a[n]=key;
		
		while(true) {
			if(a[i]==key)
				break;
			i++;
		}
		return i==n? -1:i;

	}
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("Element count: ");
		int num = stdIn.nextInt();
		int[] arrayX = new int[num+1];
		
		for(int i=0; i<num; i++) {
			System.out.print("arrayX["+i+"]: ");
			arrayX[i] = stdIn.nextInt();
		}
		
		System.out.print("Value to search: ");
		int key = stdIn.nextInt();
		
		int idx=seqSearch(arrayX,num,key);
		
		if(idx==-1)
			System.out.println("Value not found in the array");
		else
			System.out.println(key+" value is in arrayX["+idx+"]");
	}

}
