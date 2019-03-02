package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//If one string can be converted to another using unlimited swap
public class OneStringToAnotherUsingSwap {
	public static void main(String args[]) throws Exception {
		// Scanner
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String str1 = s.next(); // Reading input from STDIN
		String str2 = s.next();
		check(str1, str2);
	}

	private static void check(String str1, String str2) {

		if (str1.length() != str2.length())
			System.out.print("NO");
		else {

			Map<Character, Integer> map = new HashMap<>();

			for (int i = 0; i < str1.length(); i++) {

				if (map.containsKey(str1.charAt(i))) {
					int count = map.get(str1.charAt(i));
					map.put(str1.charAt(i), count + 1);
				} else {
					map.put(str1.charAt(i), 1);
				}

			}

			for (int j = 0; j < str2.length(); j++) {
				int count1 = map.get(str2.charAt(j));
				if (count1 < 0) {
					System.out.print("NO");
				} else {
					map.put(str2.charAt(j), count1 - 1);
				}
			}

			System.out.println("YES");
		}
	}
}
