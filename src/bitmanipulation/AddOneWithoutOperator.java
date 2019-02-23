package bitmanipulation;

public class AddOneWithoutOperator {

	public static int addOne(int x) {
		int m = 1;
		while ((x & m) == 1) {
			x = x ^ m;
		}
		x = x ^ m;
		return x;
	}
	
	public static void main(String[] args) {
		System.out.println(addOne(5));
	}
}
