package sort;
import java.util.Scanner;

public class BubbleSort {
	
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void bubbleSort(int[] a, int count) {
		int flag=0; //to indicate the last idx that required swap
		while(flag<count-1) {
			int last = count-1;
			for(int j=count-1; j>flag; j--) {
				if(a[j-1]>a[j]) {
					swap(a, j-1, j);
					last = j;
				}
			}
			flag = last;
		}
	}
	
/**	static void bubbleSort(int[] a, int count) {
		for(int i=0; i<count-1; i++) {
			for(int j=count-1; j>i; j--) {
				if(a[j-1]>a[j]) {
					swap(a, j-1, j);
				}
			}
		}
	}
*/
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.println("Bubble Sort");
		System.out.print("Element count: ");
		int idxCount = read.nextInt();
		int[]arrayX = new int[idxCount];
		
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:");
			arrayX[i]=read.nextInt();
		}
		
		bubbleSort(arrayX, idxCount);
		
		System.out.println("Sorted in ascending order");
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:"+arrayX[i]+"  ");
		}
	}

}
