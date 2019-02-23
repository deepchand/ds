package bitmanipulation;

//Find position of set in number which have only one set bit
public class PositionOfSetBit {

	public static int findPositionOfSetBit(int x) {
		System.out.println("test"+ (1<<0));
		if (IsNumberPowerOfTwo.isPowerOfTwo(x) != 1)
			return 0;
		int m = 1;
		int count = 0;
		while ((x & m) == 0) {
			m <<= 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(findPositionOfSetBit(7));
	}
}
