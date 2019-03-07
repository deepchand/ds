package tree;

/*          0
          /   \
         1     0
              /  \
             1    0
            / \
           1    1        */

public class UnivalTree {

	static class Counter{
		static int count;

		public Counter(int count) {
			super();
			Counter.count = count;
		}
	}
	public static boolean countUniValTree(Node root, Counter count) {

		if (root == null)
			return true;
		boolean l = countUniValTree(root.left, count);
		boolean r = countUniValTree(root.right, count);

		if (l && r) {
			Node left = root.left;
			Node right = root.right;

			if (left == null && right == null) {
				Counter.count++;
				return true;
			} else if (right == null && root.data == left.data) {
				Counter.count++;
				return true;
			} else if (left == null && root.data == right.data) {
				Counter.count++;
				return true;
			} else if (root.data == left.data && root.data == right.data) {
				Counter.count++;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		Node root = new Node(0);
		root.left= new Node(1);
		root.right = new Node(0);
		root.right.left = new Node(1);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(1);
		root.right.right = new Node(0);
		Counter count = new Counter(0);
		countUniValTree(root, count);
		System.out.println(Counter.count);
	}
}
