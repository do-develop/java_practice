package sort;
import java.util.Scanner;

public class SelectionSort {
	
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void selectionSort(int[]a, int count) {
		for(int i=0; i<count-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<count; j++) {
				if(a[j]<a[minIdx]) {
					minIdx = j;
				}
			}
			swap(a, i, minIdx);
		}
	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.println("Selection Sort");
		System.out.print("Element count: ");
		int idxCount = read.nextInt();
		int[]arrayX = new int[idxCount];
		
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:");
			arrayX[i]=read.nextInt();
		}
		
		selectionSort(arrayX, idxCount);
		
		System.out.println("Sorted in ascending order");
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:"+arrayX[i]+"  ");
		}
	}

}
