package sorting;

public class QuickSort {

	public static int partition(int arr[], int low, int high) {
		int pivot = arr[low];
		int i = low;
		int j = high;
		while (i < j) {
			while (arr[i] <= pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i < j) {
				swap(arr, i, j);
			}
		}
		swap(arr, low, j);
		return j;
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void quickSortUtil(int arr[], int low, int high) {
		if (low < high) {
			int j = partition(arr, low, high);
			quickSortUtil(arr, low, j - 1);
			quickSortUtil(arr, j + 1, high);
		}
	}

	public static void quickSort(int arr[]) {
		int length = arr.length;
		quickSortUtil(arr, 0, length - 1);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 16, 8, 12, 15, 6, 3, 9, 5 };
		quickSort(arr);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
