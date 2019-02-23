package dp;

public class LCS {

	public static int lcs(String first, String second) {
		int m = first.length();
		int n = second.length();
		int dp[][] = new int[m + 1][n + 1];
		for (int i = 0; i < n + 1; i++)
			dp[0][i] = 0;
		for (int j = 0; j < m + 1; j++)
			dp[j][0] = 0;
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (first.charAt(i - 1) == second.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		printActualLcs(dp, m, n, first, second);
		return dp[m][n];
	}

	public static void printActualLcs(int dp[][], int m, int n, String first, String second) {
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (first.charAt(i-1) == second.charAt(j-1)) {
				System.out.print(" "+first.charAt(i-1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
	}

	public static void main(String[] args) {
		String first = "AGGTAB";
		String second = "GXTXAYB";
		System.out.println(lcs(first, second));
	}
}
