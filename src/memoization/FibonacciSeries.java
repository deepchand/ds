package memoization;

public class FibonacciSeries {
	public static int fibonacci(int n, int memo[]) {
		if (memo[n] != 0)
			return memo[n];
		else if (n == 1 || n == 2) {
			memo[n] = 1;
			return memo[n];
		} else {
			memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
			return memo[n];
		}
	}

	public static void main(String[] args) {
		int n = 6;
		System.out.println(fibonacci(n, new int[n+1]));
	}
}
