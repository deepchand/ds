package miscellaneous;

import java.util.Random;

public class CalculatingPIUsingMonteCarlo {

	public static double calculatePi(double n) {

		double c = 0;
		Random r = new Random();

		for (int i = 1; i < n; i++) {
			double x = -1 + 2 * r.nextDouble();
			double y = -1 + 2 * r.nextDouble();

			if (x * x + y * y < 1) {
				c = c + 1;
			}
		}
		return (4 * c) / n;
	}

	public static void main(String[] args) {
		System.out.println(calculatePi(100000));
	}
}
