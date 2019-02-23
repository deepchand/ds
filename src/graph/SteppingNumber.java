package graph;

import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumber {

	public static void stepping(int n, int m) {
		for (int i = 0; i < 10; i++) {
			bfs(n, m, i);
		}
	}

	private static void bfs(int n, int m, int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while (!q.isEmpty()) {
			int stepNum = q.poll();
			if (stepNum <= m && stepNum >= n)
				System.out.print(stepNum + " ");
			if (stepNum == 0 || stepNum > m)
				continue;
			int lastDigit = stepNum % 10;
			int stepNumA = stepNum * 10 + (lastDigit - 1);
			int stepNumB = stepNum * 10 + (lastDigit + 1);
			if (lastDigit == 0)
				q.add(stepNumB);
			if (lastDigit == 9)
				q.add(stepNumA);
			else {
				q.add(stepNumA);
				q.add(stepNumB);
			}
		}
	}

	public static void main(String[] args) {
		int n = 0;
		int m = 200;
		stepping(n, m);
	}
}
