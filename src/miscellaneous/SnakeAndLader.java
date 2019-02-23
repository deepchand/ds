package miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLader {

	static class QEntry {
		int v;
		int dist;
	}

	public static void main(String[] args) {
		// Let us construct the board given in above diagram
		int N = 30;
		int moves[] = new int[N];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is " + getMinDiceThrows(moves, N));
	}

	private static int getMinDiceThrows(int[] moves, int n) {
		boolean visited[] = new boolean[moves.length];
		Queue<QEntry> q = new LinkedList<>();
		QEntry qe = new QEntry();
		qe.dist = 0;
		qe.v = 0;
		visited[0] = true;
		q.add(qe);
		while (!q.isEmpty()) {
			qe = q.remove();
			int v = qe.v;
			if (v == n - 1)
				break;
			for (int j = v + 1; j <= (v + 6) && j < n; j++) {
				if (!visited[j]) {
					QEntry a = new QEntry();
					a.dist = qe.dist + 1;
					visited[j] = true;
					if (moves[j] != -1) {
						a.v = moves[j];
					} else {
						a.v = j;
					}
					q.add(a);
				}
			}
		}
		return qe.dist;
	}
}
