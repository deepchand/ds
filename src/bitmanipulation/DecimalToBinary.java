package bitmanipulation;

public class DecimalToBinary {

	public static void toBinary(int n) {
		if (n > 1)
			toBinary(n >> 1);
		System.out.print(n & 1);
	}
	public static void main(String[] args) {
		toBinary(100);
	}
}
