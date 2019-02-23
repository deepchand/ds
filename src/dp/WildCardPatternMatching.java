package dp;

public class WildCardPatternMatching {

	public static boolean isPatternMatch(String str, String pattern) {
		int m = str.length();
		int n = pattern.length();
		if (m == 0)
			return (n == 0);
		boolean dp[][] = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int j = 1; j <= n; j++) {
			if (pattern.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (pattern.charAt(j - 1) == '*')
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				else if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == str.charAt(i - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = false;
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String str = "baaabab"; 
        String pattern = "*****ba*****ab";
		System.out.println(isPatternMatch(str, pattern));
	}
}
