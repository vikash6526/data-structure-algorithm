package datastructure.sorting;

public class MergeSort {

	public void mSort(int[] arr) {
		if (arr.length <= 1)
			return;
		mSort(arr, 0, arr.length - 1);
	}

	private void mSort(int[] arr, int i, int j) {
		if (j <= i)
			return;
		int mid = (i + j) / 2;
		mSort(arr, i, mid);
		mSort(arr, mid + 1, j);
		merge(arr, i, mid, j);

	}

	private void merge(int[] arr, int i, int mid, int j) {
		int[] temp = new int[j - i + 1];

		int leftSlot = i;
		int rightSlot = mid + 1;
		int k = 0;

		while (leftSlot <= mid && rightSlot <= j) {
			if (arr[leftSlot] < arr[rightSlot]) {
				temp[k] = arr[leftSlot];
				leftSlot++;
			} else {
				temp[k] = arr[rightSlot];
				rightSlot++;
			}
			k++;
		}

		if (leftSlot <= mid) {
			while (leftSlot <= mid) {
				temp[k] = arr[leftSlot];
				leftSlot++;
				k++;
			}
		} else if (rightSlot <= j) {
			while (rightSlot <= j) {
				temp[k] = arr[rightSlot];
				rightSlot++;
				k++;
			}
		}

		for (int p = 0; p < temp.length; p++) {
			arr[p + i] = temp[p];
		}
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 3, 6, 5 };

		MergeSort ms = new MergeSort();
		ms.mSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
