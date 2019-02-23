package recursion;

public class SubSetSumProblem {
	public static boolean isSubSetSum(int arr[], int n, int sum) {
		if (sum == 0) {
			return true;
		}
		if (n == 0 && sum != 0)
			return false;
		if (arr[n - 1] > sum)
			return isSubSetSum(arr, n - 1, sum);
		return isSubSetSum(arr, n - 1, sum) || isSubSetSum(arr, n - 1, sum - arr[n - 1]);
	}

	public static void main(String[] args) {
		int arr[] = { 3, 34, 4, 12, 5, 2 };
		System.out.println(isSubSetSum(arr, 6, 11));
	}
}
