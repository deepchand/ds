package tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {

	public static void printTopView(Node root) {
		class QNode {
			int hd;
			Node node;

			public QNode(int hd, Node node) {
				super();
				this.hd = hd;
				this.node = node;
			}
		}
		Queue<QNode> q = new LinkedList<>();
		Map<Integer, Node> map = new TreeMap<>();
		if (root == null) {
			return;
		} else {
			q.add(new QNode(0, root));
		}
		while (!q.isEmpty()) {
			QNode qNode = q.poll();
			if (!map.containsKey(qNode.hd))
				map.put(qNode.hd, qNode.node);
			if (qNode.node.left != null) {
				q.add(new QNode(qNode.hd - 1, qNode.node.left));
			}
			if (qNode.node.right != null) {
				q.add(new QNode(qNode.hd + 1, qNode.node.right));
			}
		}
		for (Entry<Integer, Node> entry : map.entrySet()) {
			System.out.print(entry.getValue().data + " ");
		}
	}
	public static void main(String[] args) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.right = new Node(4); 
        root.left.right.right = new Node(5); 
        root.left.right.right.right = new Node(6); 
        printTopView(root);
	}
}
