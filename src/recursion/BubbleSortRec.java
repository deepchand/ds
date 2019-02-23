package recursion;

import sorting.BubbleSort;

public class BubbleSortRec {
	public static void bubbleSortRec(int arr[], int n) {
		for (int j = 0; j < arr.length - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
		bubbleSortRec(arr, n - 1);
	}

	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {34,20,45,60,27};
		BubbleSort.bubbleSort(arr);
		BubbleSort.printArray(arr);
	}
}
