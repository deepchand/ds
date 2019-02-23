package dp;

public class MaxSizeSquareSubMatrix {

	public static void maxSizeSquareMatrix(int mat[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		int maxI = 0;
		int maxJ = 0;
		int maxS = 0;
		int dp[][] = new int[rows][cols];
		for (int i = 0; i < cols; i++) {
			dp[0][i] = mat[0][i];
		}
		for (int j = 0; j < rows; j++) {
			dp[j][0] = mat[j][0];
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (mat[i][j] == 1) {
					int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
					dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;
				} else {
					dp[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (maxS < dp[i][j]) {
					maxS = dp[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}

		for (int i = maxI; i > maxI - maxS; i--) {
			for (int j = maxJ; j > maxJ - maxS; j--) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int M[][] = {{0, 1, 1, 0, 1},  
                {1, 1, 0, 1, 0},  
                {0, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 0}, 
                {1, 1, 1, 1, 1}, 
                {0, 0, 0, 0, 0}}; 
		maxSizeSquareMatrix(M);
	}
}
