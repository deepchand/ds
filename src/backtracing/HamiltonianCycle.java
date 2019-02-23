package backtracing;

public class HamiltonianCycle {

	public static boolean isSafe(int v, int path[], int mat[][], int pos) {
		if (mat[path[pos - 1]][v] == 0)
			return false;
		for (int i = 0; i < pos; i++) {
			if (path[i] == v)
				return false;
		}
		return true;
	}

	public static void findCycle(int mat[][], int path[], int pos) {
		if (pos == mat.length) {
			if (mat[pos - 1][0] == 1) {
				for (int i = 0; i < path.length; i++)
					System.out.print(path[i]+" ");
				System.out.println();
			}
		}
		for (int v = 1; v < mat.length; v++) {
			if (isSafe(v, path, mat, pos)) {
				path[pos] = v;
				findCycle(mat, path, pos + 1);
				path[pos] = -1;
			}
		}
	}

	public static void hamCycle(int mat[][]) {
		int path[] = new int[mat.length];
		for (int i = 0; i < mat.length; i++)
			path[i] = -1;
		path[0] = 0;
		findCycle(mat, path, 1);
	}

	public static void main(String[] args) {
		int mat[][] = { { 0, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 } };
		hamCycle(mat);
	}
}
