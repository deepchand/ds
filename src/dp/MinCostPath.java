package dp;

public class MinCostPath {

	public static int minCostFromSToD(int cost[][], int n) {
		int minCost[] = new int[n];
		minCost[0] = 0;
		minCost[1] = cost[0][1];
		for (int i = 2; i < n; i++) {
			minCost[i] = cost[0][i];
			for (int j = 1; j < i; j++) {
				if (minCost[i] > minCost[j] + cost[j][i]) {
					minCost[i] = minCost[j] + cost[j][i];
				}
			}
		}
		return minCost[n - 1];
	}

	public static void main(String[] args) {
		int cost[][] = { { 0, 10, 75, 94 }, { -1, 0, 35, 50 }, { -1, -1, 0, 80 }, { -1, -1, -1, 0 } };
		System.out.println(minCostFromSToD(cost, 4));
	}
}
