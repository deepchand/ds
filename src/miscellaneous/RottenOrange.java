package miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

//Minimum time required to rot all oranges
public class RottenOrange {

	public final static int R = 3;
	public final static int C = 5;

	static class Ele {
		int x;
		int y;

		public Ele(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static boolean isValid(int i, int j) {
		return (i >= 0 && j >= 0 && i < R && j < C);
	}

	public static boolean isDelim(Ele ele) {
		return (ele.x == -1 && ele.y == -1);
	}

	static boolean checkAll(int arr[][]) {
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				if (arr[i][j] == 1)
					return true;
		return false;
	}

	static int rotOranges(int arr[][]) {

		Queue<Ele> q = new LinkedList<>();
		Ele temp;
		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 2) {
					q.add(new Ele(i, j));
				}
			}
		}
		q.add(new Ele(-1, -1));
		while (!q.isEmpty()) {
			boolean flag = false;
			while (!isDelim(q.peek())) {

				temp = q.peek();
				if (isValid(temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x + 1][temp.y] = 2;
					q.add(new Ele(temp.x + 1, temp.y));
				}

				if (isValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x - 1][temp.y] = 2;
					q.add(new Ele(temp.x - 1, temp.y));
				}

				if (isValid(temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x][temp.y + 1] = 2;
					q.add(new Ele(temp.x, temp.y + 1));
				}

				if (isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
					if (!flag) {
						flag = true;
						ans++;
					}
					arr[temp.x][temp.y - 1] = 2;
					q.add(new Ele(temp.x, temp.y - 1));
				}
				q.remove(temp);
			}
			q.remove();
			if (!q.isEmpty()) {
				q.add(new Ele(-1, -1));
			}
		}
		return (checkAll(arr)) ? -1 : ans;
	}

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);
	}
}
