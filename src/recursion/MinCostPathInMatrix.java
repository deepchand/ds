package recursion;

public class MinCostPathInMatrix {

	public static int minCostPath(int cost[][], int m, int n) {
		if (m == 0 && n == 0) {
			return cost[m][n];
		}
		if (m == 0) {
			return minCostPath(cost, m, n - 1)+cost[0][n];
		}
		if (n == 0)
			return minCostPath(cost, m - 1, n)+cost[m][0];
		int x = minCostPath(cost, m - 1, n);
		int y = minCostPath(cost, m, n - 1);
		int min = x < y ? x : y;
		return min + cost[m][n];
	}

	public static void main(String[] args) {
		int cost[][] = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
		System.out.println(minCostPath(cost, 2, 3));
	}
}
