package recursion;

public class CalculateXPowerN {

	public int calculateXPowerN(int x, int n) {

		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		return x * calculateXPowerN(x, n - 1);
	}

	public static void main(String[] args) {
		CalculateXPowerN calculateXPowerN = new CalculateXPowerN();
		System.out.println(calculateXPowerN.calculateXPowerN(2, 12));
	}
}
