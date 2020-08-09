package datastructure.sorting;

import java.util.Arrays;

public class ShellSort {

	public static int[] shellSort(int[] arr) {
		int n = arr.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int j = gap; j < n; j++) {
				for (int i = j - gap; i >= 0; i = i - gap) {
					if (arr[i] < arr[i + gap])
						break;
					else {
						int temp = arr[i];
						arr[i] = arr[i + gap];
						arr[i + gap] = temp;
					}
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(shellSort(new int[] { 23, 29, 15, 19, 31, 7, 9, 5, 2 })));

	}

}
