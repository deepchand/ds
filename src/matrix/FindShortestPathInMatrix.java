/**
 * 
 */
package matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author deepchandswami
 *
 */
/*
 * Given a MxN matrix where each element can either be 0 or 1. We need to find
 * the shortest path between a given source cell to a destination cell. The path
 * can only be created out of a cell if its value is 1.
 */
public class FindShortestPathInMatrix {

	static final int ROW = 4;
	static final int COl = 4;
	static int rowN[] = { -1, 0, 0, 1 };
	static int colN[] = { 0, -1, 1, 0 };

	static class QNode {
		int dist;
		Point point;

		public QNode(int dist, Point point) {
			super();
			this.dist = dist;
			this.point = point;
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	private static boolean isValid(int row, int col) {
		return (row >= 0 && col >= 0 && row < ROW && col < COl);
	}

	public static int findShortestPath(int mat[][], Point src, Point dest) {

		if (mat[src.x][src.y] == 0 || mat[dest.x][dest.y] == 0)
			return -1;

		Queue<QNode> q = new LinkedList<>();
		boolean visited[][] = new boolean[mat.length][mat[0].length];

		QNode qNode = new QNode(0, src);
		visited[src.x][src.y] = true;
		q.add(qNode);

		while (!q.isEmpty()) {
			QNode temp = q.remove();
			Point p = temp.point;
			int dist = temp.dist;

			if (dest.x == p.x && dest.y == p.y) {
				return dist;
			}

			for (int i = 0; i < 4; i++) {
				int r = rowN[i] + p.x;
				int c = colN[i] + p.y;
				if (isValid(r, c) && !visited[r][c] && mat[r][c] == 1) {
					Point p1 = new Point(r, c);
					QNode qNode2 = new QNode(dist + 1, p1);
					visited[r][c] = true;
					q.add(qNode2);
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int mat[][] = { { 1, 1, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 } };
		Point src = new Point(0, 0);
		Point dest = new Point(3, 3);
		System.out.println(findShortestPath(mat, src, dest));
	}
}
