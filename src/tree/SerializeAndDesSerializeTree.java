package tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDesSerializeTree {

	public static int count =0;
	public static void serialize(Node root, List<Integer> arr) {
		if (root == null) {
			arr.add(-1);
			return;
		}

		arr.add(root.data);
		serialize(root.left, arr);
		serialize(root.right, arr);
	}

	public static Node deSerialize(List<Integer> arr) {

		if (arr.isEmpty() || count >= arr.size())
			return null;
		int ele = arr.get(count++);
		if (ele == -1)
			return null;
		Node root = new Node(ele);
		root.left = deSerialize(arr);
		root.right = deSerialize(arr);
		return root;
	}

	private static void doSerializeAndDe(Node root) {
		List<Integer> arr = new ArrayList<>();
		serialize(root, arr);
		arr.forEach(System.out::print);
		System.out.println();
		Node root1 = deSerialize(arr);
		Node.printPreOrder(root1);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.right = new Node(3);
		root.right.right = new Node(5);

		Node.printPreOrder(root);
		System.out.println();
		doSerializeAndDe(root);
	}
}
