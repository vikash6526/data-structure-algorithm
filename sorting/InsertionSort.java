package datastructure.sorting;

public class InsertionSort {

	public static int[] insertionSort(int[] nums) {
		for (int i = 0; i < nums.length-1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (nums[j] < nums[j-1]) {
					int temp = nums[j];
					nums[j] = nums[j-1];
					nums[j-1] = temp;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		insertionSort(new int[] { 25, 47, 3, 19, 8, 18 });
	}
}
