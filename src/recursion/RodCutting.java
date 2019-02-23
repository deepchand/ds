package recursion;

public class RodCutting {

	public static int minCost(int value[], int n) {
		if (n <= 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int temp = value[i] + minCost(value, n - i-1);
			if (max < temp)
				max = temp;
		}
		return max;
	}

	public static void main(String[] args) {
		int length = 4;
		int value[] = {1, 5, 8, 9, 10, 17, 17, 20 };
		System.out.println(minCost(value, length));
	}
}
