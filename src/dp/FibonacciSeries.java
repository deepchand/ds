package dp;

public class FibonacciSeries {

	public static int fibonacci(int n) {
		if (n == 1 || 2 == n)
			return n;
		int a = 1;
		int b = 1;
		int c = 0;
		for (int i = 3; i <=n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(4));
	}
}
