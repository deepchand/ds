package backtracing;

public class NQueen {

	public static final int N = 4;

	public static void printSolution(int board[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	public static boolean isSafe(int board[][], int row, int col) {

		int i, j;
		for (i = 0; i < row; i++) {
			if (board[i][col] == 1)
				return false;
		}
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}

		for (i = row, j = col; i < N && j < N; i++, j++)
			if (board[i][j] == 1)
				return false;

		for (i = row, j = col; i < N && j >= 0; i++, j--) {
			if (board[i][j] == 1)
				return false;
		}

		for (i = row, j = col; j < N && i >= 0; i--, j++) {
			if (board[i][j] == 1)
				return false;
		}

		return true;
	}

	public static boolean solveNQUtil(int board[][], int row) {
		if (row == N) {
			printSolution(board);
			System.out.println();
			return true;
		}
		boolean res = false;
		for (int j = 0; j < N; j++) {
			if (isSafe(board, row, j)) {
				board[row][j] = 1;
				res = solveNQUtil(board, row + 1) || res;
				if (res)
					return true;
				board[row][j] = 0;
			}
		}
		return res;
	}

	public static boolean solveNQ() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveNQUtil(board, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		printSolution(board);
		return true;
	}

	public static void main(String[] args) {
		solveNQ();
	}
}
