package bitmanipulation;

public class IsNumberPowerOfTwo {

	public static int isPowerOfTwo(int n) {
		int x = n & (n - 1);
		return (x == 0) ? 1 : 0;
	}
	public static void main(String[] args) {
		int x = 33;
		if(isPowerOfTwo(x)==1)
			System.out.println(x +" is power of two");
		else {
			System.out.println(x +" is not power of two");
		}
	}
}
