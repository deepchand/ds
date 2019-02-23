package memoization;

public class LCS {

	public static int lcs(String first, String second, int m, int n, int memo[][]) {
		if (memo[m][n] != 0)
			return memo[m][n];
		if (m == 0 || n == 0)
			return 0;
		if (first.charAt(m - 1) == second.charAt(n - 1)) {
			memo[m][n] = 1 + lcs(first, second, m - 1, n - 1, memo);
			return memo[m][n];
		} else {
			memo[m][n] = Math.max(lcs(first, second, m - 1, n, memo), lcs(first, second, m, n - 1, memo));
			return memo[m][n];
		}
	}

	public static void main(String[] args) {
		String first = "AGGTAB";
		String second = "GXTXAYB";
		int memo[][] = new int[first.length() + 1][second.length() + 1];
		System.out.println(lcs(first, second, 6, 7, memo));
	}
}
