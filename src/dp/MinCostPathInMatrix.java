package dp;

public class MinCostPathInMatrix {

	public static int minCostPath(int cost[][], int m, int n) {
		int minCost[][] = new int[m+1][n+1];
		minCost[0][0] = cost[0][0];
		for (int i = 1; i <=n; i++) {
			minCost[0][i] = cost[0][i] + minCost[0][i - 1];
		}
		for (int j = 1; j <=m; j++) {
			minCost[j][0] = cost[j][0] + minCost[j - 1][0];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int min = minCost[i - 1][j] < minCost[i][j - 1] ? minCost[i - 1][j] : minCost[i][j - 1];
				minCost[i][j] = min + cost[i][j];
			}
		}
		return minCost[m][n];
	}

	public static void main(String[] args) {
		int cost[][] = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
		System.out.println(minCostPath(cost, 2, 3));
	}
}
