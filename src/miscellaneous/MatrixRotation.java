package miscellaneous;

public class MatrixRotation {

	public static void rotate(int mat[][]) {
		int n = mat.length;
		for (int x = 0; x < n / 2; x++) {
			for (int y = x; y < n - x - 1; y++) {
				int temp = mat[x][y];
				mat[x][y] = mat[y][n - x - 1];
				mat[y][n - 1 - x] = mat[n - 1 - x][n - 1 - y];
				mat[n - 1 - x][n - 1 - y] = mat[n - 1 - y][x];
				mat[n - 1 - y][x] = temp;
			}
		}
	}

	public static void print(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(mat);
		rotate(mat);
		print(mat);
	}
}
