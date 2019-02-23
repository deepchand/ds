package recursion;

//Minimum number of jumps to reach end
public class MinNumberOfJump {

	public static int minJump(int arr[], int l, int h) {
		if (l == h)
			return 0;
		if (arr[l] == 0)
			return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			int j = minJump(arr, i, h);
			if (j != Integer.MAX_VALUE && j + 1 < min)
				min = j+1;
		}
		return min;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(minJump(arr, 0, arr.length - 1));
	}
}
