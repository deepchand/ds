package dp;

public class LIS {

	public static int lis(int arr[], int n) {
		int lis[] = new int[n];
		int actual[] = new int[n];
		int maxIndex = 0;
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			actual[i] = i;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (lis[i] < 1 + lis[j] && arr[i] > arr[j]) {
					lis[i] = 1 + lis[j];
					actual[i] = j;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (lis[i] > lis[maxIndex]) {
				maxIndex = i;
			}
		}
		int t = maxIndex;
		int newT = maxIndex;
		do {
			t = newT;
			System.out.print(arr[newT] + " ,");
			newT = actual[t];
		} while (t != newT);
		System.out.println();
		return lis[maxIndex];
	}

	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(lis(arr, 9));
	}
}
