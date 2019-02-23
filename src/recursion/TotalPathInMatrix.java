package recursion;

public class TotalPathInMatrix {
	public static int totalPath(int m, int n) {
		if (m == 0 && n == 0)
			return 0;
		if (m == 0 || n == 0)
			return 1;
		return totalPath(m - 1, n) + totalPath(m, n - 1);
	}

	public static void main(String[] args) {
		System.out.println(totalPath(1, 1));
	}
}
