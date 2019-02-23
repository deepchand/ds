package string;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfString {

	public static void permute(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		char string[] = new char[map.size()];
		int count[] = new int[map.size()];
		char result[] = new char[str.length()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			string[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		permuteUtil(string, count, result, 0);
	}

	public static void permuteUtil(char string[], int count[], char result[], int level) {
		if (level == result.length) {
			printResult(result);
			return;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0)
				continue;
			result[level] = string[i];
			count[i]--;
			permuteUtil(string, count, result, level + 1);
			count[i]++;
		}
	}

	public static void printResult(char result[]) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String str = "ABC";
		permute(str);
	}
}
