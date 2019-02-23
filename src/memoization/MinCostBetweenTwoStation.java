package memoization;

public class MinCostBetweenTwoStation {
	public static int minCost(int s, int d, int cost[][], int memo[][]) {
		if (s == d || s == d - 1)
			return cost[s][d];
		if (memo[s][d] == 0) {
			int minCost = cost[s][d];
			for (int i = s + 1; i < d; i++) {
				int tempCost = minCost(s, i, cost, memo) + minCost(i, d, cost, memo);
				if (tempCost < minCost)
					minCost = tempCost;
			}
			memo[s][d] = minCost;
		}
		return memo[s][d];
	}

	public static void main(String[] args) {
		int cost[][] = { { 0, 10, 75, 94 }, { -1, 0, 35, 50 }, { -1, -1, 0, 80 }, { -1, -1, -1, 0 } };
		System.out.println(MinCostBetweenTwoStation.minCost(0, 3, cost, new int[cost.length][cost.length]));
	}
}
