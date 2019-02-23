package graph;

public class NumberOfConnectedComponent {

	static int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static boolean isSafe(int row, int col, int mat[][], boolean visited[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		return (row >= 0) && (row < rows) && (col >= 0) && (col < cols) && (mat[row][col] == 1 && !visited[row][col]);
	}

	public static void Dfs(int row, int col, int mat[][], boolean visited[][]) {
		visited[row][col] = true;
		for (int k = 0; k < 8; k++) {
			if (isSafe(row + rowNbr[k], col + colNbr[k], mat, visited)) {
				Dfs(row + rowNbr[k], col + colNbr[k], mat, visited);
			}
		}
	}

	public static int connectedComponent(int mat[][]) {
		int rows = mat.length;
		int cols = mat[0].length;
		boolean visited[][] = new boolean[rows][cols];
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (mat[i][j] == 1 && !visited[i][j]) {
					Dfs(i, j, mat, visited);
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 0, 0, 0, 1 }, { 1, 1, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 },
				{ 1, 0, 0, 0, 1, 1 } };
		System.out.println(connectedComponent(mat));
	}
}
