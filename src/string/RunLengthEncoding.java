/**
 * 
 */
package string;

/**
 * @author deepchandswami
 *
 */
public class RunLengthEncoding {

	public static String encoding(String str) {

		String result = "";

		int count = 1;

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			while (i < str.length()-1 && c == str.charAt(i + 1)) {
				count++;
				i++;
			}

			result = result + count + c;
			count = 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "aaaabbbccdaa";
		System.out.println(encoding(str));
	}
}
