package graph;

public class LargestRegion {
	static int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static boolean isSafe(int row, int col, int mat[][], boolean visited[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		return (row >= 0) && (row < rows) && (col >= 0) && (col < cols) && (mat[row][col] == 1 && !visited[row][col]);
	}

	public static void Dfs(int row, int col, int mat[][], boolean visited[][], Count count) {
		visited[row][col] = true;
		for (int k = 0; k < 8; k++) {
			if (isSafe(row + rowNbr[k], col + colNbr[k], mat, visited)) {
				count.count = count.count + 1;
				Dfs(row + rowNbr[k], col + colNbr[k], mat, visited, count);
			}
		}
	}

	public static int connectedComponent(int mat[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		boolean visited[][] = new boolean[rows][cols];
		int maxRegion = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Count count = new Count(0);
				if (mat[i][j] == 1 && !visited[i][j]) {
					Dfs(i, j, mat, visited, count);
					maxRegion = Math.max(maxRegion, count.count+1);
				}
			}
		}
		return maxRegion;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 1, 1 } };
		System.out.println(connectedComponent(mat));
	}
}
