package miscellaneous;

public class NextSmallestPlaindrome {

	private static boolean isAllNines(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			if (arr[i] != 9)
				return false;
		}
		return true;
	}

	private static void generateNextPalindromeUtil(int arr[], int n) {

		int mid = n / 2;
		int i = mid - 1;
		int j = n % 2 == 0 ? mid : mid + 1;
		boolean leftSmaller = false;

		while (i >= 0 && arr[i] == arr[j]) {
			i--;
			j++;
		}

		if (i < 0 || arr[i] < arr[j]) {
			leftSmaller = true;
		}

		while (i >= 0) {
			arr[j++] = arr[i--];
		}
		if (leftSmaller) {
			int carry = 1;

			if (n % 2 == 1) {
				arr[mid] = arr[mid] + carry;
				carry = arr[mid] / 10;
				arr[mid] = arr[mid] % 10;
			}

			i = mid - 1;
			j = n % 2 == 0 ? mid : mid + 1;
			while (i >= 0) {
				arr[i] = arr[i] + carry;
				carry = arr[i] / 10;
				arr[i] = arr[i] % 10;
				arr[j++] = arr[i--];
			}
		}
	}

	static void printarray(int num[]) {
		for (int i = 0; i < num.length; i++)
			System.out.print(num[i]);
		System.out.println();
	}

	static void generateNextPalindrome(int num[], int n) {
		System.out.println("Next Palindrome is:");

		// Input type 1: All the digits are 9,
		// simply o/p 1 followed by n-1 0's
		// followed by 1.
		if (isAllNines(num, n)) {
			System.out.print("1");
			for (int i = 0; i < n - 1; i++)
				System.out.print("0");
			System.out.println("1");

		}

		// Input type 2 and 3
		else {
			generateNextPalindromeUtil(num, n);
			printarray(num);
		}
	}

	public static void main(String[] args) {
		int num[] = { 1, 2, 9, 9, 2, 1 };
		generateNextPalindrome(num, num.length);
	}
}
