package tree;

import java.util.HashMap;
import java.util.Map;

/*Given an array that represents a tree in such a way 
that array indexes are values in tree nodes and array 
values give the parent node of that particular index (or node). 
The value of the root node index would always be -1 as there is no parent for root.

{1, 5, 5, 2, 2, -1, 3}
Output: root of below tree
          5
        /  \
       1    2
      /    / \
     0    3   4
         /
        6 */
public class BuildBtFromParentArray {

	public static Node buildTree(int arr[], int n) {

		Node root = null;
		Map<Integer, Node> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new Node(i));
		}
		
		for (int i = 0; i < n; i++) {
			
			if (arr[i] == -1) {
				root = map.get(i);
				continue;
			}
			
			Node temp = map.get(arr[i]);
			
			if (temp.left == null)
				temp.left = map.get(i);
			else
				temp.right = map.get(i);
		}
		return root;
	}

	public static void main(String[] args) {

		int arr[] = {1, 5, 5, 2, 2, - 1, 3 };

		Node root = buildTree(arr, arr.length);

		Node.printInOrder(root);
	}
}
