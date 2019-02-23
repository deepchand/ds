package tree;

import java.util.Stack;

public class MergeTwoBst {

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void merge(Node root1, Node root2) {
		Node current1 = root1, current2 = root2;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		if (root1 == null)
			inorder(root2);
		if (root2 == null)
			inorder(root1);
		while (current1 != null || current2 != null || !s1.isEmpty() || !s2.isEmpty()) {

			if (current1 != null || current2 != null) {
				if (current1 != null) {
					s1.push(current1);
					current1 = current1.left;
				}
				if (current2 != null) {
					s2.push(current2);
					current2 = current2.left;
				}
			} else {
				if (s1.isEmpty()) {
					while (!s2.isEmpty()) {
						current2 = s2.pop();
						current2.left = null;
						inorder(current2);
					}
					return;
				}
				if (s2.isEmpty()) {
					while (!s1.isEmpty()) {
						current1 = s1.pop();
						current1.left = null;
						inorder(current1);
					}
					return;
				}
				current1 = s1.pop();
				current2 = s2.pop();
				if (current1.data < current2.data) {
					System.out.print(current1.data + " ");
					current1 = current1.right;
					s2.push(current2);
					current2 = null;
				} else {
					System.out.print(current2.data + " ");
					current2 = current2.right;
					s1.push(current1);
					current1 = null;
				}
			}
		}
	}

	public static void main(String[] args) {
		Node root1 = null;
		Node root2 = null;
		root1 = new Node(3);
		root1.left = new Node(1);
		root1.right = new Node(5);

		/*
		 * Let us create the following tree as second tree 4 / \ 2 6
		 */
		root2 = new Node(4);
		root2.left = new Node(2);
		root2.right = new Node(6);

		// Print sorted nodes of both trees
		merge(root1, root2);
	}
}
