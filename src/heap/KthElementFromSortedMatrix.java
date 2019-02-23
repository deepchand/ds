package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//Find the kth smallest element from sorted matrix
public class KthElementFromSortedMatrix {

	static class Element {
		int data;
		int row;
		int col;

		public Element(int data, int row, int col) {
			this.data = data;
			this.row = row;
			this.col = col;
		}
	}

	public static int findKthSmallest(int mat[][], int k) {
		PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {
			@Override
			public int compare(Element o1, Element o2) {
				return o1.data - o2.data;
			}
		});
		int cols = mat[0].length;
		for (int i = 0; i < cols; i++) {
			pq.add(new Element(mat[0][i], 0, i));
		}
		Element e = new Element(-1, 0, 0);
		for (int i = 1; i <= k; i++) {
			e = pq.remove();
			pq.add(new Element(mat[e.row + 1][e.col], e.row + 1, e.col));
		}
		return e.data;
	}

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 24, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(findKthSmallest(mat, 5));
	}
}
