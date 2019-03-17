package sorting;

public class DutchNationalFlag {

	public static void sortArray(int arr[], int n) {
		int low = 0, mid = 0;
		int high = n - 1;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, high);
				high--;
				break;

			default:
				break;
			}
		}
	}

	public static void swap(int arr[], int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}

	public static void printArray(int arr[], int arr_size) {
		int i;
		for (i = 0; i < arr_size; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int arr_size = arr.length;
		sortArray(arr, arr_size);
		System.out.println("Array after seggregation ");
		printArray(arr, arr_size);
	}
}
