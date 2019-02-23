package miscellaneous;

import java.util.Stack;

public class PatternPrinting {

	public static void printPattern(String seq) {
		String result = "";
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i <= seq.length(); i++) {
			stack.push(i + 1);
			if (seq.length() == i || seq.charAt(i) == 'I') {
				while (!stack.isEmpty()) {
					result = result + String.valueOf(stack.pop());
					result = result + " ";
				}
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		String seq = "IIDDI";
		printPattern(seq);
	}
}
