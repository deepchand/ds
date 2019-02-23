package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCoding {

	static class HuffmanNode {
		int data;
		char c;
		HuffmanNode left;
		HuffmanNode right;
	}

	public static HuffmanNode createHuffmanTree(int charFreq[], char letters[]) {

		PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(new Comparator<HuffmanNode>() {
			@Override
			public int compare(HuffmanNode o1, HuffmanNode o2) {
				return o1.data - o2.data;
			}
		});

		for (int i = 0; i < charFreq.length; i++) {
			HuffmanNode hn = new HuffmanNode();
			hn.c = letters[i];
			hn.data = charFreq[i];
			hn.left = null;
			hn.right = null;
			q.add(hn);
		}

		HuffmanNode root = null;

		while (q.size() > 1) {
			HuffmanNode x = q.peek();
			q.poll();

			// second min extarct.
			HuffmanNode y = q.peek();
			q.poll();

			// new node f which is equal
			HuffmanNode f = new HuffmanNode();

			f.c = '-';
			f.data = x.data + y.data;

			f.left = x;
			f.right = y;

			root = f;

			q.add(f);
		}
		return root;
	}

	public static void printCode(HuffmanNode root, String s) {

		if (root.left == null && root.right == null && Character.isLetter(root.c)) {
			System.out.println(root.c + ":" + s);
			return;
		}
		printCode(root.left, s + "0");
		printCode(root.right, s + "1");
	}

	public static void main(String[] args) {
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };
		HuffmanNode hn = createHuffmanTree(charfreq, charArray);
		printCode(hn, "");
	}
}
