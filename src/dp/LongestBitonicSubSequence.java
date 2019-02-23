package dp;

public class LongestBitonicSubSequence {

	public static int lbs(int arr[], int n) {
		int lis[] = new int[n];
		int lds[] = new int[n];
		int max = lis[0] + lds[0] - 1;
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (lis[i] < 1 + lis[j] && arr[i] > arr[j]) {
					lis[i] = 1 + lis[j];
				}
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (lds[i] < 1 + lds[j] && arr[i] > arr[j]) {
					lds[i] = 1 + lds[j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (lis[i] + lds[i] - 1 > max) {
				max = lds[i] + lis[i] - 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(lbs(arr, 9));
	}
}
