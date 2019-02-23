package recursion;

public class CatalanNumber {

	public static int catalanValue(int n) {
		if (n <=1)
			return 1;
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += catalanValue(i) * catalanValue(n - i-1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(catalanValue(4));
	}
}
