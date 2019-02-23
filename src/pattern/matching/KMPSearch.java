package pattern.matching;

public class KMPSearch {

	public static boolean hasSubString(char text[], char pattern[]) {
		int i = 0, j = 0, k = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				j = 0;
				k++;
				i = k;
			}

			if (j == pattern.length)
				return true;
		}
		return false;
	}

	private static int[] computeTempArray(char pattern[]) {
		int lps[] = new int[pattern.length];
		int j = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[j] == pattern[i]) {
				lps[i] = j + 1;
				j++;
				i++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static boolean Kmp(char text[], char pattern[]) {
		int lcs[] = computeTempArray(pattern);
		int i = 0, j = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lcs[j - 1];
				} else {
					i++;
				}
			}
			if (j == pattern.length)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String text = "abcxabcdabcdabcy";
		String pattern = "abcdabcy";
		boolean result = Kmp(text.toCharArray(), pattern.toCharArray());
		System.out.println("has substring : " + result);
	}
}
