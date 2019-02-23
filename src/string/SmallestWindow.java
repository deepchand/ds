package string;

import java.util.HashMap;
import java.util.Map;

//Find the smallest window in a string containing all characters of another string
public class SmallestWindow {

	public static String findSmallestWindow(String str, String t) {
		if (str.length() == 0 || t.length() == 0) {
			return "";
		}
		Map<Character, Integer> countMap = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			int count = countMap.getOrDefault(t.charAt(i), 0);
			countMap.put(t.charAt(i), count + 1);
		}
		int l = 0;
		int r = 0;
		int required = countMap.size();
		int formed = 0;
		int ans[] = { -1, 0, 0 };
		Map<Character, Integer> smallestWindow = new HashMap<>();
		while (r < str.length()) {
			Character ch = str.charAt(r);
			int count = smallestWindow.getOrDefault(ch, 0);
			smallestWindow.put(ch, count + 1);
			if (countMap.containsKey(ch) && countMap.get(ch) == smallestWindow.get(ch))
				formed++;
			while (l <= r && formed == required) {
				ch = str.charAt(l);
				if (ans[0] == -1 || r - l + 1 < ans[0]) {
					ans[0] = r - l + 1;
					ans[1] = l;
					ans[2] = r;
				}
				smallestWindow.put(ch, smallestWindow.get(ch) - 1);
				if (countMap.containsKey(ch) && countMap.get(ch) > smallestWindow.get(ch))
					formed--;
				l++;
			}
			r++;
		}
		return ans[0] == -1 ? "" : str.substring(ans[1], ans[2] + 1);
	}
	public static void main(String[] args) {
		String str = "this is a test string";
		String t = "tistt";
		System.out.println(findSmallestWindow(str, t));
	}
}
