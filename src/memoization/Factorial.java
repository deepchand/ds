package memoization;

public class Factorial {

	public static long fact(int n, int memo[]) {
		if (n == 1)
			return 1;
		if (memo[n] != 0)
			return memo[n];
		return n * fact(n - 1, memo);
	}

	public static void main(String[] args) {
		System.out.println(fact(5, new int[6]));
	}
}
