package dp;

public class KadanesAlgo {

	public static int maxSubArraySum(int array[]) {
		int max_ending_here = 0, max_so_far = 0;
		for (int i = 0; i < array.length; i++) {
			max_ending_here += array[i];
			if (max_ending_here < 0)
				max_ending_here = 0;
			else if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	public static void main(String[] args) {
		int array[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(maxSubArraySum(array));
	}
}
