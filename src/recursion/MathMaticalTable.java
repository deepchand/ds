package recursion;

public class MathMaticalTable {
	public static void mathmaticalTable(int n, int i) {
		if (i == 11) {
			return;
		}
		System.out.println(n * i);
		mathmaticalTable(n, i + 1);
	}

	public static void main(String[] args) {
		MathMaticalTable.mathmaticalTable(2, 1);
	}
}
