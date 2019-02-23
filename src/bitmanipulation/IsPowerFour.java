package bitmanipulation;

public class IsPowerFour {

	public static int isPowerFour(int n) {
		int count = 0;
		int x = n & (n - 1);
		if (n > 0 && x == 0) {
			while (n > 1) {
				n >>= 1;
				count++;
			}
			return (count % 2 == 0) ? 1 : 0;
		}
		return 0;
	}

	public static void main(String[] args) {
		int test_no = 60;

		if (isPowerFour(test_no) > 0)
			System.out.println(test_no + " is a power of 4");
		else
			System.out.println(test_no + " is not a power of 4");
	}
}
