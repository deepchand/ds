/**
 * 
 */
package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author deepchandswami
 *
 */
public class MaxLengthSubStringHighFreq {

	public static int maxFreq(String str) {

		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			String s = "";
			for (int j = i; j < str.length(); j++) {
				s = s + str.charAt(j);
				int freq = map.getOrDefault(s, 0);
				map.put(s, freq + 1);
			}
		}
		String s = "";
		int max = 0;
		for (String t : map.keySet()) {
			int freq = map.get(t);
			if (freq > max) {
				max = freq;
				s = t;
			} else if (freq == max) {
				if (t.length() > s.length())
					s = t;
			}
		}
		return s.length();
	}
	
	public static void main(String[] args) {
		String str = "ababecdecd";
		System.out.println(maxFreq(str));
	}
}
