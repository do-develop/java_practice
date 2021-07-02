package sort;

import java.util.Scanner;

public class InsertionSort {
	
	static void insertionSort(int[]a, int count) {
		for(int i=1; i<count; i++) {
			int j;
			int tmp = a[i];
			for(j=i; j>0 && a[j-1]>tmp; j--) {
				a[j] = a[j-1];
			}
			a[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.println("Insertion Sort");
		System.out.print("Element count: ");
		int idxCount = read.nextInt();
		int[]arrayX = new int[idxCount];
		
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:");
			arrayX[i]=read.nextInt();
		}
		
		insertionSort(arrayX, idxCount);
		
		System.out.println("Sorted in ascending order");
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:"+arrayX[i]+"  ");
		}
	}

}
