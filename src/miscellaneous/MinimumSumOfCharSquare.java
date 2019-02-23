package miscellaneous;

import java.util.PriorityQueue;

//Minimum sum of squares of character counts in a given string after removing k characters
public class MinimumSumOfCharSquare {

	public static final int CHAR_SIZE = 26;

	public static int minStringValue(String str, int k) {

		int length = str.length();
		if (k >= length)
			return 0;
		int freq[] = new int[CHAR_SIZE];
		for (int i = 0; i < length; i++) {
			freq[str.charAt(i) - 'a']++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((Integer o1, Integer o2) -> {
			if (o1 > o2)
				return -1;
			else if (o1 < o2)
				return 1;
			else
				return 0;
		});

		for (int i = 0; i < CHAR_SIZE; i++) {
			if (freq[i] != 0) {
				pq.add(freq[i]);
			}
		}

		while (k != 0) {
			int temp = pq.poll();
			temp = temp - 1;
			pq.add(temp);
			k--;
		}

		int result = 0;
		while (!pq.isEmpty()) {
			int temp = pq.remove();
			result += temp * temp;
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "abbccc"; // Input 1
		int k = 2;
		System.out.println(minStringValue(str, k));

		str = "aaab"; // Input 2
		k = 2;
		System.out.println(minStringValue(str, k));
	}
}
