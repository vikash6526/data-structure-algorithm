package datastructure.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingSort {

	public static int[] countingSort1(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int[] count = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		int k = 0;
		for (int i = 0; i < count.length; i++) {
			int limit = count[i];
			while (limit > 0) {
				arr[k++] = i;
				limit--;
			}
		}
		return arr;
	}

	public static int[] countingSort2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int data : arr) {
			if (!map.containsKey(data))
				map.put(data, 1);
			else
				map.put(data, map.get(data) + 1);
		}
		int k = 0;
		for (Integer key : map.keySet()) {
			int limit = map.get(key);
			while (limit > 0) {
				arr[k++] = key;
				limit--;
			}
		}
		return arr;
	}

	public static int[] countingSort(int[] arr) {
		int[] result = new int[arr.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int[] count = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			result[--count[arr[i]]] = arr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 1, 0, 2, 5, 4, 0, 2, 8, 7, 7, 9, 2, 0, 1, 9 };
		System.out.println(Arrays.toString(countingSort(arr)));

	}

}
