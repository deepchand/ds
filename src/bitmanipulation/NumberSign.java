package bitmanipulation;

public class NumberSign {
	public static void main(String[] args) {
		int x = 20;
		int y = -20;
		System.out.println(opposite(x, y));
	}

	static boolean opposite(int x, int y) {
		return ((x ^ y) < 0);
	}
}
