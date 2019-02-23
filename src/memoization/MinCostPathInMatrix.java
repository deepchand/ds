package memoization;

public class MinCostPathInMatrix {
	public static int minCostPath(int cost[][], int m, int n, int memo[][]) {
		if (memo[m][n] != 0)
			return memo[m][n];
		if (m == 0 && n == 0) {
			memo[m][n] = cost[m][n];
			return memo[m][n];
		}
		if (m == 0) {
			memo[0][n] = minCostPath(cost, m, n - 1, memo) + cost[0][n];
			return memo[0][n];
		}
		if (n == 0) {
			memo[m][0] = minCostPath(cost, m - 1, n, memo) + cost[m][0];
			return memo[m][0];
		}

		int x = minCostPath(cost, m - 1, n, memo);
		int y = minCostPath(cost, m, n - 1, memo);
		int min = x < y ? x : y;
		memo[m][n] = min + cost[m][n];
		return memo[m][n];
	}

	public static void main(String[] args) {
		int cost[][] = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
		int[][] memo = new int[3][4];
		System.out.println(minCostPath(cost, 2, 3, memo));
	}
}
