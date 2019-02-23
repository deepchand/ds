package miscellaneous;

public class PascalTringle {

	public static void printPascalTringle(int n) {

		for (int line = 0; line < n; line++) {
			for (int i = 0; i <= line; i++) {
				System.out.print(findCofficent(line, i) + " ");
			}
			System.out.println();
		}
	}

	// calculate !line/!line-i*!i
	public static int findCofficent(int line, int i) {
		int m = 1, n = 1, o = 1;
		for (int j = 1; j <= line; j++)
			m = m * j;
		for (int j = 1; j <= line - i; j++)
			n = n * j;
		for (int j = 1; j <= i; j++)
			o = o * j;
		return m / (n * o);
	}

	public static void main(String[] args) {
		printPascalTringle(5);
	}
}
