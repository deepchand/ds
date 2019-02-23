package backtracing;

public class RatInMaze {
	public static final int N = 4;

	private static void printSolution(int[][] maze) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isSafe(int mat[][], int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && mat[x][y] == 1);
	}

	public static boolean findSol(int sol[][], int maze[][], int x, int y) {
		if (x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(maze, x, y)) {
			sol[x][y] = 1;

			if (findSol(sol, maze, x + 1, y))
				return true;
			if (findSol(sol, maze, x, y + 1))
				return true;
			sol[x][y] = 0;
		}
		return false;
	}

	public static boolean solveMaze(int maze[][]) {
		int sol[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (findSol(sol, maze, 0, 0) == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}

		printSolution(sol);
		return true;
	}

	public static void main(String args[]) {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		solveMaze(maze);
	}
}
