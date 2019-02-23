package recursion;

public class NoOfEditToConvertString {

	public static int findNoOfEdit(String str1, String str2, int m, int n) {
		if (m == 0)
			return n;
		if (n == 0)
			return m;
		if (str1.charAt(m - 1) == str2.charAt(n - 1))
			return findNoOfEdit(str1, str2, m - 1, n - 1);
		int d = findNoOfEdit(str1, str2, m - 1, n);
		int r = findNoOfEdit(str1, str2, m - 1, n - 1);
		int i = findNoOfEdit(str1, str2, m, n - 1);
		int min = Math.min(d, r);
		int finalMin = Math.min(min, i);
		return finalMin + 1;
	}

	public static void main(String[] args) {
		String str1 = "saturday";
		String str2 = "sunday";
		System.out.println(findNoOfEdit(str1, str2, str1.length(), str2.length()));
	}
}
