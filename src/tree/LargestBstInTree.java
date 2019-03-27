/**
 * 
 */
package tree;

/**
 * @author deepchandswami
 *
 */
public class LargestBstInTree {

	public static class MinMax {
		int min;
		int max;
		int size;
		boolean isBST;

		MinMax() {
			this.min = Integer.MAX_VALUE;
			this.max = Integer.MIN_VALUE;
			this.size = 0;
			this.isBST = true;
		}
	}

	private static MinMax largestBst(Node root) {
		if(root == null){
            return new MinMax();
        }
        
        //postorder traversal of tree. First visit left and right then
        //use information of left and right to calculate largest BST.
        MinMax leftMinMax = largestBst(root.left);
        MinMax rightMinMax =largestBst(root.right);
        
        MinMax m = new MinMax();
        
        //if either of left or right subtree says its not BST or the data
        //of this node is not greater/equal than max of left and less than min of right
        //then subtree with this node as root will not be BST. 
        //Return false and max size of left and right subtree to parent
        if(leftMinMax.isBST == false || rightMinMax.isBST == false || (leftMinMax.max > root.data || rightMinMax.min < root.data)){
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }
        
        //if we reach this point means subtree with this node as root is BST.
        //Set isBST as true. Then set size as size of left + size of right + 1.
        //Set min and max to be returned to parent.
        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;
        //if root.left is null then set root.data as min else
        //take min of left side as min
        m.min = root.left != null ? leftMinMax.min : root.data;
  
        //if root.right is null then set root.data as max else
        //take max of right side as max.
        m.max = root.right != null ? rightMinMax.max : root.data;
   
        return m;
	}
	
	public static int largestBSTUtil(Node root){
        MinMax m = largestBst(root);
        return m.size;
    }
	
	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		root.right = new Node(60);
		root.right.left = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(70);
		System.out.println(largestBSTUtil(root));
	}
}
