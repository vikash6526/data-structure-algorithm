package datastructure.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static int[] bubbleSort(int[] arr) {
		int pass = 0;
		while (pass <= arr.length - 1) {
			boolean noSwapping = true;
			for (int i = 0; i < arr.length - 1 - pass; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					noSwapping = false;
				}
			}
			if (noSwapping)
				break;
			pass++;
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(bubbleSort(new int[] { 16, 14, 5, 6, 8 })));
	}

}
