package datastructure.sorting;

import java.util.Arrays;

public class RadixSort {
	public static int[] radixSort(int[] arr) {
		int max = getMax(arr);
		for (int pos = 1; (max / pos) > 0; pos *= 10) {
			arr = countSort(arr, pos);
		}
		return arr;
	}

	private static int[] countSort(int[] arr, int pos) {
		int[] count = new int[10];
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			count[(arr[i] / pos) % 10]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			result[--count[(arr[i] / pos) % 10]] = arr[i];
		}
		return result;
	}

	private static int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(radixSort(new int[] { 432, 8, 530, 90, 88, 231, 11, 45, 677, 199 })));

	}

}
