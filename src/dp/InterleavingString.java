package dp;

public class InterleavingString {

	public static boolean isInterleaving(String a, String b, String c) {
		int m = a.length();
		int n = b.length();
		if (c.length() != m + n)
			return false;
		boolean mat[][] = new boolean[m + 1][n + 1];
		mat[0][0] = true;
		for (int i = 1; i <= n; i++) {
			if (b.charAt(i - 1) == c.charAt(i - 1))
				mat[0][i] = mat[0][i - 1];
		}
		for (int j = 1; j <= m; j++) {
			if (a.charAt(j - 1) == c.charAt(j - 1))
				mat[j][0] = mat[j - 1][0];
		}
		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {
				if (a.charAt(i - 1) == c.charAt(i + j - 1) && b.charAt(j - 1) != c.charAt(i + j - 1))
					mat[i][j] = mat[i - 1][j];
				if (a.charAt(i - 1) != c.charAt(i + j - 1) && b.charAt(j - 1) == c.charAt(i + j - 1))
					mat[i][j] = mat[i][j - 1];
				if (a.charAt(i - 1) == c.charAt(i + j - 1) && b.charAt(j - 1) == c.charAt(i + j - 1))
					mat[i][j] = mat[i][j - 1] || mat[i - 1][j];
				else
					mat[i][j] = false;
			}
		}
		return mat[m][n];
	}

	public static void main(String[] args) {
		String a = "bcc";
		String b = "bbca";
		String c = "bbcbcac";
		System.out.println(isInterleaving(a, b, c));
	}
}
