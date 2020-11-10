package datastructure.sorting;

public class SelectionSort {

	public static int[] selectionSort(int[] nums) {
		//int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		selectionSort(new int[] { 25, 47, 3, 19, 8, 18 });

	}

}
