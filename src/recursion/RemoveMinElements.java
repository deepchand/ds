package recursion;

//Remove minimum elements from either side such that 2*min becomes more than max
public class RemoveMinElements {

	public static int memo[][] = new int[9][9];

	static int min(int arr[], int l, int h) {
		int mn = arr[l];
		for (int i = l + 1; i <= h; i++)
			if (mn > arr[i])
				mn = arr[i];
		return mn;
	}

	// A utility function to find maximum in arr[l..h]
	static int max(int arr[], int l, int h) {
		int mx = arr[l];
		for (int i = l + 1; i <= h; i++)
			if (mx < arr[i])
				mx = arr[i];
		return mx;
	}

	public static int removeElements(int arr[], int l, int h) {
		if (l >= h)
			return 0;
		int min = min(arr, l, h);
		int max = max(arr, l, h);
		if (2 * min > max)
			return 0;

		if (memo[l][h] != 0)
			return memo[l][h];

		memo[l][h] = Math.min(removeElements(arr, l + 1, h), removeElements(arr, l, h - 1)) + 1;
		return memo[l][h];
	}

	public static void main(String[] args) {
		int arr[] = { 4, 5, 100, 9, 10, 11, 12, 15, 200 };
		System.out.println(removeElements(arr, 0, arr.length - 1));
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(memo[i][j]+" ");
			}
			System.out.println();
		}
	}
}
