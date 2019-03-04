package arrays;

public class MinSubArrayToMakeAllArraySorted {

	public static void findIndex(int arr[]) {

		int i = 0;
		int n = arr.length;
		int j = n - 1;
		int min;
		int max;
		int minIndex = 0;
		int maxIndex = n - 1;
		while (i < n && arr[i] < arr[i + 1]) {
			i++;
		}
		if (i == n - 1) {
			System.out.println("complete array is sorted");
			return;
		}
		while (j >= 0 && arr[j] > arr[j - 1]) {
			j--;
		}
		if (j == 0) {
			System.out.println("complete array is sorted in reverse order");
			return;
		}
		min = arr[i];
		max = arr[j];
		for (int k = i; k <= j; k++) {
			if (arr[k] < min) {
				min = arr[k];
			}
			if (arr[k] > max) {
				max = arr[k];
			}
		}
		for (int x = 0; x < i; x++) {
			if (arr[x] > min)
				minIndex = x;
		}

		for (int y = n - 1; y > j; y--) {
			if (arr[y] < max)
				maxIndex = y;
		}
		System.out.println("starting index is :" + minIndex + " ending index is: " + maxIndex);
	}

	public static void main(String[] args) {
		int arr[] = { 0, 1, 15, 25, 6, 7, 30, 40, 50 };
		findIndex(arr);
	}
}
