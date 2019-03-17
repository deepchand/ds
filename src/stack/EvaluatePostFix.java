/**
 * 
 */
package stack;

import java.util.Stack;

/**
 * @author deepchandswami
 *
 */
public class EvaluatePostFix {

	public static int evaluateExp(String str) {
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c == ' ')
				continue;

			else if (Character.isDigit(c)) {
				int n = 0;
				while (Character.isDigit(c)) {
					n = n * 10 + (int) c - '0';
					i++;
					c = str.charAt(i);
				}
				i--;
				s.push(n);
			} else {
				int val1 = s.pop();
				int val2 = s.pop();

				switch (c) {
				case '*':
					s.push(val2 * val1);
					break;
				case '/':
					s.push(val2 / val1);
					break;
				case '+':
					s.push(val2 + val1);
					break;
				case '-':
					s.push(val2 - val1);
					break;

				default:
					break;
				}
			}
		}
		return s.pop();
	}

	public static void main(String[] args) {
		String str = "100 200 + 2 / 5 * 7 +";
		System.out.println(evaluateExp(str));
	}
}
