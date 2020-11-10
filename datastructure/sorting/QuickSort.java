package datastructure.sorting;

import java.util.Arrays;

public class QuickSort {

	public static int[] quickSort(int[] nums, int p, int r) {

		if (p < r) {
			int q = partition(nums, p, r);
			quickSort(nums, p, q - 1);
			quickSort(nums, q + 1, r);
		}

		return nums;
	}

	private static int partition(int[] nums, int p, int r) {
		int i = -1, j = 0;
		while (j <= r) {
			if (nums[j] <= nums[r]) {
				i++;
				int temp = nums[j];
				nums[j] = nums[i];
				nums[i] = temp;
				j++;
			} else {
				j++;
			}
		}

		return i;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 10, 7, 1, 3, 5, 8, 9, 6 };
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));

	}

}
