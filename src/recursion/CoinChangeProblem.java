package recursion;

public class CoinChangeProblem {

	public static int coinChange(int arr[], int n, int sum) {
		if (sum == 0)
			return 0;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] <= sum) {
				int temp = coinChange(arr, n, sum - arr[i]);
				if (temp + 1 < result)
					result = temp + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 6, 9 };
		System.out.println(coinChange(arr, arr.length, 11));
	}
}
