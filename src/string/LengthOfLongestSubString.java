package string;

//Length of longest substring of digits such that 
//sum of left half and right half is equal
public class LengthOfLongestSubString {

	public static int maxSubStringLength(String original) {
		int maxLength = 0;
		for (int i = 0; i < original.length(); i++) {
			for (int j = i + 1; j < original.length(); j+=2) {
				int length = j - i + 1;
				if (maxLength >= length)
					continue;
				int lSum = 0, rSum = 0;
				for (int k = 0; k < length / 2; k++) {
					lSum += original.charAt(i + k) - '0';
					rSum += original.charAt(i + k + length / 2) - '0';
					if (lSum == rSum)
						maxLength = length;
				}
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		//String original = "142124";
		String original = "41233219";
		System.out.println(maxSubStringLength(original));
	}
}
