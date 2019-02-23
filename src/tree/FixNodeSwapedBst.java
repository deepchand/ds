package tree;

public class FixNodeSwapedBst {

	static Node first;
	static Node middle;
	static Node last;
	static Node prev;

	public static void fixNodeOfBst(Node root) {
		if (root != null) {
			fixNodeOfBst(root.left);

			if (prev != null && root.data < prev.data) {

				if (first == null) {
					first = prev;
					middle = root;
				} else {
					last = root;
				}
			}

			prev = root;

			fixNodeOfBst(root.right);
		}
	}

	public static void correctBST(Node root) {
		first = middle = last = prev = null;

		fixNodeOfBst(root);

		if (first != null && last != null) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}
		// Adjacent nodes swapped
		else if (first != null && middle != null) {
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}

	}

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);
		Node.printInOrder(root);
		System.out.println();
		correctBST(root);
		Node.printInOrder(root);
	}
}
