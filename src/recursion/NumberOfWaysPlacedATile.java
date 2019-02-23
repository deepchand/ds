package recursion;

//Applicable for 2*n plot and 2*1 tile size
public class NumberOfWaysPlacedATile {

	public static int countWays(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return countWays(n - 1) + countWays(n - 2);
	}
	public static void main(String[] args) {
		System.out.println(countWays(6));
	}
}
