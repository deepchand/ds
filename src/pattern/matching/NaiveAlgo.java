package pattern.matching;

public class NaiveAlgo {

	public static boolean isPatternMatch(String text, String pattern) {
		int n = text.length();
		int m = pattern.length();
		for (int i = 0; i < n - m;) {
			for (int j = 0; j < m;) {
				if (text.charAt(i) == pattern.charAt(j)) {
					if (j == m - 1) {
						System.out.println("pattern found at : " + (i-j));
						return true;
					}
					i++;
					j++;
				} else {
					i = i - j + 1;
					j = 0;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String text = "ababcabcababdababd";
		String pattern = "ababd";
		System.out.println(isPatternMatch(text, pattern));
	}
}
