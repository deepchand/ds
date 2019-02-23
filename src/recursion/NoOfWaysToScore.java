package recursion;

// No ways to reach  score given player can make point 3,5,10
public class NoOfWaysToScore {
	public static int countWays(int n) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;
		return countWays(n - 10) + countWays(n - 5) + countWays(n - 3);
	}

	public static void main(String[] args) {
		System.out.println(countWays(13));
	}
}
