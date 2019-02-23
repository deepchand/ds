package dp;

//Given unlimited supply of coins
public class CoinChangeProblem {

	public static int minCoins(int arr[], int sum) {
		int l = arr.length;
		int dp[][] = new int[l][sum + 1];
		for (int i = 0; i < sum + 1; i++) {
			dp[0][i] = i;
		}
		for (int j = 0; j < l; j++) {
			dp[j][0] = 0;
		}

		for (int i = 1; i < l; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (j >= arr[i]) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - arr[i]] + 1);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		return dp[l-1][sum];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5, 10, 20 };
		System.out.println(minCoins(arr, 13));
	}
}
