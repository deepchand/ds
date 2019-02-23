package recursion;

public class LIS {

	public static int lis(int arr[], int prev, int n) {
		if (arr.length == n)
			return 0;
		int taken = 0;
		if (arr[n] > prev) {
			taken = 1 + lis(arr, arr[n], n + 1);
		}	
		int notTaken = lis(arr, prev, n + 1);
		return Math.max(taken, notTaken);
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(lis(arr, Integer.MIN_VALUE, 0));
	}
}
