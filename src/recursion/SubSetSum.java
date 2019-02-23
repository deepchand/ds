package recursion;

// find sub set from array having given sum
public class SubSetSum {

	public static boolean isSubSetSum(int arr[], int n, int sum) {

		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;
		if (sum < arr[n - 1])
			return isSubSetSum(arr, n - 1, sum);
		return isSubSetSum(arr, n - 1, sum) || isSubSetSum(arr, n - 1, sum - arr[n - 1]);
	}

	public static boolean findPartition(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0)
			return false;
		return isSubSetSum(arr, n, sum / 2);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, 11, 5};
		System.out.println(findPartition(arr, arr.length));
	}
}
