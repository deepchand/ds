/**
 * 
 */
package tree;

/**
 * @author deepchandswami
 *
 */
public class IsGivenTreeBst {

	private static boolean isBst(Node root, int min, int max) {

		if (root == null)
			return true;

		if (root.data < min || root.data > max)
			return false;

		return isBst(root.left, min, root.data) && isBst(root.right, root.data, max);
	}

	public static boolean isBstUtil(Node root) {
		return isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(-10);
		root.right = new Node(19);
		root.left.left = new Node(-20);
		root.left.right = new Node(0);
		root.right.left = new Node(17);
		System.out.println(isBstUtil(root));
	}
}
