package sort;

import java.util.Scanner;

public class MergeSort {
	
	static int[] buff;
	
	static void __mergeSort(int[]a, int left, int right) {
		if(left<right) {
			int i;
			int center = (left+right)/2;
			int ptr1=0;
			int ptr2=0;
			int ptr3 = left;
			
			__mergeSort(a, left, center);
			__mergeSort(a, center+1, right);
			
			for(i=left; i<=center; i++)
				buff[ptr1++] = a[i];
			
			while(i<=right && ptr2<ptr1)
				a[ptr3++] = (buff[ptr2]<=a[i])? buff[ptr2++]:a[i++];
				
			while(ptr2<ptr1)
				a[ptr3++] = buff[ptr2++];
		}
	}
	
	static void mergeSort(int[]a, int n) {
		buff = new int[n];
		__mergeSort(a, 0, n-1);
		buff = null;
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		System.out.println("Merge sort");
		System.out.print("Array size: ");
		int idxCount = read.nextInt();
		int[]arrayX = new int[idxCount];
		
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:");
			arrayX[i]=read.nextInt();
		}
		
		mergeSort(arrayX, idxCount);
		
		System.out.println("Sorted in ascending order");
		for(int i=0; i<idxCount; i++) {
			System.out.print("arrayX["+i+"]:"+arrayX[i]+"  ");
		}

	}

}
