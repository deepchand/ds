package recursion;

public class LCS {

	public static int lcs(String first, String second, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (first.charAt(m - 1) == second.charAt(n - 1))
			return 1 + lcs(first, second, m - 1, n - 1);
		else {
			return Math.max(lcs(first, second, m - 1, n), lcs(first, second, m, n - 1));
		}
	}

	public static void main(String[] args) {
		String first = "AGGTAB";
		String second = "GXTXAYB";
		System.out.println(lcs(first, second, 6, 7));
	}
}
