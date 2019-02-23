package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKsorted {

	public static Node merge(Node a, Node b) {
		if (a == null)
			return b;
		if (null == b)
			return a;
		Node result = null;
		if (a.data < b.data) {
			result = a;
			result.next = merge(a.next, b);
		}
		if (b.data < a.data) {
			result = b;
			result.next = merge(a, b.next);
		}
		return result;
	}

	public static Node mergeKSorted(Node arr[], int last) {
		while (last != 0) {
			int i = 0, j = last;
			while (i < j) {
				arr[i] = merge(arr[i], arr[j]);
				i++;
				j--;
				if (i >= j)
					last = j;
			}
		}
		return arr[0];
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	// This method is based on Min heap

	public static Node mergeKSortedUsingHeap(Node arr[], int k) {
		Node head = null, last = null;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.data - o2.data;
			}
		});
		for (int i = 0; i < k; i++)
			pq.add(arr[i]);
		while (!pq.isEmpty()) {
			Node top = pq.peek();
			pq.remove();
			if (top.next != null)
				pq.add(top.next);
			if (head == null) {
				head = top;
				// points to the last node so far of
				// the final merged list
				last = top;
			} else {
				// insert 'top' at the end of the merged list so far
				last.next = top;
				// update the 'last' pointer
				last = top;
			}
		}
		return head;
	}

	public static void main(String args[]) {
		int k = 3; // Number of linked lists

		// an array of pointers storing the head nodes
		// of the linked lists
		Node arr[] = new Node[k];

		arr[0] = new Node(1);
		arr[0].next = new Node(3);
		arr[0].next.next = new Node(5);
		arr[0].next.next.next = new Node(7);

		arr[1] = new Node(2);
		arr[1].next = new Node(4);
		arr[1].next.next = new Node(6);
		arr[1].next.next.next = new Node(8);

		arr[2] = new Node(0);
		arr[2].next = new Node(9);
		arr[2].next.next = new Node(10);
		arr[2].next.next.next = new Node(11);

		// Merge all lists
		//Node head = mergeKSorted(arr, k - 1);
		Node head = mergeKSortedUsingHeap(arr, k);
		printList(head);
	}
}
