package backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array of positive integers arr[] and a sum x, 
//find all unique combinations in arr[] where the sum is equal to x. 
//The same repeated number may be chosen from arr[] unlimited number of time

public class CombinationalSum {

	public static void printSolution(List<Integer> result) {
		for (int i : result)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void combinationalSum(int arr[], List<Integer> list, int i, int sum) {

		if (sum < 0 || i > arr.length)
			return;

		if (sum == 0) {
			printSolution(list);
		}

		for (int j = i; j < arr.length; j++) {
			list.add(arr[j]);
			combinationalSum(arr, list, j, sum - arr[j]);
			list.remove(list.size() - 1);
		}
	}

	public static void sumUtil(int arr[], int sum) {
		Arrays.sort(arr);
		combinationalSum(arr, new ArrayList<>(), 0, sum);
	}

	public static void main(String[] args) {
		int arr[] = { 2, 4, 6, 8 };
		sumUtil(arr, 8);
	}
}
