package miscellaneous;

import java.util.Arrays;

public class NumberOfTriangle {

	public static int countTriangle(int arr[], int n) {
		if (n < 3)
			return 0;
		Arrays.sort(arr);

		int count = 0;
		for (int i = 0; i < n - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < n - 1; j++) {

				while (k < n && arr[i] + arr[j] > arr[k])
					k++;

				if (k > j)
					count += k - j - 1;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 21, 22, 100, 101, 200, 300 };
		System.out.println(countTriangle(arr, arr.length));
	}
}
