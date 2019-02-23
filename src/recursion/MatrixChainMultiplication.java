package recursion;

public class MatrixChainMultiplication {

	public static int matrixChainOrder(int p[], int i, int j) {

		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int k = i; k < j; k++) {
			int cost = matrixChainOrder(p, i, k) + matrixChainOrder(p, k + 1, j) + p[i - 1] * p[k] * p[j];
			if (cost < min)
				min = cost;
		}
		return min;
	}

	public static void main(String[] args) {
		int m[] = { 1, 2, 3, 4 ,3};
		System.out.println(matrixChainOrder(m, 1, m.length - 1));
	}
}
