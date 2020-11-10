package datastructure.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivitySelectionProblem {
	public static int[] activitySelectionproblem(int[] s, int[] f) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < f.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (f[j] < f[j - 1]) {
					int temp = f[j];
					f[j] = f[j - 1];
					f[j - 1] = temp;
					int temp1 = s[j];
					s[j] = s[j - 1];
					s[j - 1] = temp1;
				}
			}
		}
		int i = 0;
		list.add(0);
		for (int j = 1; j < s.length; j++) {
			if (f[i] <= s[j]) {
				list.add(j);
				i = j;
			}
		}
		int[] result = new int[list.size()];
		int k = 0;
		for (Integer data : list) {
			result[k++] = data;
		}
		return result;
	}

	public static int[] activitySelectionProblem(int[][] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j][1] < arr[j - 1][1]) {
					int[] temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				}
			}
		}
		List<Integer> list = new ArrayList<>();
		int j = 0;
		list.add(0);
		for (int i = 1; i < arr.length; i++) {
			if (arr[j][1] <= arr[i][0]) {
				list.add(i);
				j = i;
			}
		}
		int[] result = new int[list.size()];
		int k = 0;
		for (Integer data : list) {
			result[k++] = data;
		}
		return result;
	}

	public static void main(String[] args) {

		int[] s = new int[] { 5, 1, 3, 0, 5, 8 };
		int[] f = new int[] { 9, 2, 4, 6, 7, 9 };

		System.out.println(Arrays.toString(activitySelectionproblem(s, f)));

		int[][] arr = new int[][] { { 5, 9 }, { 1, 2 }, { 3, 4 }, { 0, 6 }, { 5, 7 }, { 8, 9 } };
		System.out.println(Arrays.toString(activitySelectionProblem(arr)));
	}

}
