/**
 * 
 */
package tree;

/**
 * @author deepchandswami
 *
 */
public class LcaInBinaryTree {

	public static Node lca(Node root, int n1, int n2) {

		if (root == null)
			return null;

		if (root.data == n1 || root.data == n2)
			return root;

		Node left = lca(root.left, n1, n2);
		Node right = lca(root.right, n1, n2);

		if (left != null && right != null)
			return root;

		return left != null ? left : right;
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(-10);
		root.right = new Node(19);
		root.left.left = new Node(-20);
		root.left.right = new Node(0);
		root.right.left = new Node(17);
		System.out.println(lca(root, -20, 0).data);
	}
}
