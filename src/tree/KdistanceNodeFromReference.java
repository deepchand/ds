/**
 * 
 */
package tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author deepchandswami
 *
 */

public class KdistanceNodeFromReference {

	public static void printKDistance(Node root, Node ref, int k) {

		if (root == null || ref == null)
			return;

		Map<Node, Node> nodeVsParentNode = new HashMap<Node, Node>();
		Set<Node> set = new HashSet<>();

		buildMap(nodeVsParentNode, root, null);

		int currentLevel = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(ref);
		set.add(ref);
		while (currentLevel <= k) {
			int size = q.size();

			while (size > 0) {

				Node temp = q.remove();
				if (temp.left != null && !set.contains(temp.left)) {
					set.add(temp.left);
					q.add(temp.left);
				}

				if (temp.right != null && !set.contains(temp.right)) {
					set.add(temp.right);
					q.add(temp.right);
				}

				Node parent = nodeVsParentNode.get(temp);

				if (parent != null && !set.contains(parent)) {
					set.add(parent);
					q.add(parent);
				}
				size--;
			}
			currentLevel++;
		}

		q.forEach(n -> {
			System.out.print(n.data + " ");
		});
	}

	private static void buildMap(Map<Node, Node> map, Node root, Node parent) {
		if (root == null)
			return;
		map.put(root, parent);
		buildMap(map, root.left, root);
		buildMap(map, root.right, root);
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
		Node target = root.left.right;
		printKDistance(root, target, 2);
	}
}
