package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftAndRightNodeOfBT {

	public static void printLeftAndRightNode(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int nodeCount = q.size();
			int n = nodeCount;
			while (n-1 >= 0) {
				Node temp = q.remove();
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
				if (nodeCount == 1) {
					System.out.print(temp.data + " ");
				} else {
					if (n == nodeCount)
						System.out.print(temp.data + " ");
					if (n-1 == 0)
						System.out.print(temp.data + " ");
				}
				n--;
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(15);
		root.right = new Node(20);
		root.right.right = new Node(25);
		printLeftAndRightNode(root);
	}
}
