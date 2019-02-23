package tree;

import java.util.ArrayList;
import java.util.List;

public class PrintKSumPath {
	public static void printKSumPath(Node root, List<Integer> list, int k) {
		if (root == null)
			return;
		list.add(root.data);
		printKSumPath(root.left, list, k);
		printKSumPath(root.right, list, k);
		int sum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			sum += list.get(i);
			if (sum == k)
				printList(list, i);
		}
		list.remove(list.size() - 1);
	}

	public static void printList(List<Integer> list, int i) {
		for (int j = i; j < list.size(); j++) {
			System.out.print(list.get(j) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		root.right.left = new Node(4);	
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(2);

		int k = 5;
		printKSumPath(root, new ArrayList<>(), k);
	}
}
