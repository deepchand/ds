package dp;

public class SubSetSumDp {

	public static boolean findPartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0)
			return false;
		return isSubSetSum(arr, n, sum / 2);
	}

	private static boolean isSubSetSum(int[] arr, int n, int sum) {
		boolean dp[][] = new boolean[arr.length][sum + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = true;
		}

		for (int j = 1; j <= sum; j++) {
			if (arr[0] == j)
				dp[0][j] = true;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j - arr[i - 1] >= 0)
					dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[arr.length - 1][sum];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 11, 5,6};
		System.out.println(findPartition(arr, arr.length));
	}
}
