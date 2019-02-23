package dp;

public class TotalPathCountInMatrix {

	public static int pathCount(int row, int col) {
		int path[][] = new int[row][col];
		for (int i = 0; i < col; i++) {
			path[0][i] = 1;
		}
		for (int j = 0; j < row; j++) {
			path[j][0] = 1;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				path[i][j] = path[i-1][j]+path[i][j-1];
			}
		}
		return path[row-1][col-1];
	}

	public static void main(String[] args) {
		System.out.println(pathCount(3, 4));
	}
}
