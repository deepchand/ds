package bitmanipulation;

public class Test {

	public static int test(String test) {
		int result = 0, max = 0;
		for (int i = 0; i < test.length(); i++) {
			if (test.charAt(i) == '1') {
				max++;
				result = Math.max(max, result);
			} else {
				max = 0;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(test("0011001111"));
	}
}
