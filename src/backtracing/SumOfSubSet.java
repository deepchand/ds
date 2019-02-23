package backtracing;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubSet {

	public static void printSolution(List<Integer> result) {
		for (int i : result)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void subSet(int sum, List<Integer> result, int arr[], int i) {
		if (sum == 0) {
			printSolution(result);
			return;
		}
		if (sum < 0 || i >= arr.length)
			return;
		result.add(arr[i]);
		subSet(sum - arr[i], result, arr, i + 1);
		result.remove(result.size() - 1);
		subSet(sum, result, arr, i + 1);
	}

	public static void main(String[] args) {
		int arr[] = { 5, 10, 12, 13, 15, 18 };
		int sum = 30;
		subSet(sum, new ArrayList<>(), arr, 0);
	}
}
