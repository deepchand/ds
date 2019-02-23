package miscellaneous;

import java.util.Arrays;

public class NumberOfPlatformRequired {

	public static int numOfPlatform(int arr[], int dep[]) {

		Arrays.sort(arr);
		Arrays.sort(dep);
		int maxPlatform = 1;
		int result = 0;
		int i = 1, j = 0;
		while (i < arr.length && j < arr.length) {
			if (arr[i] <= dep[j]) {
				maxPlatform++;
				i++;
				if (result < maxPlatform)
					result = maxPlatform;
			} else {
				maxPlatform--;
				j++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		System.out.println(numOfPlatform(arr, dep));
	}
}
