package dp;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSizeRectangle {

	public static int maxAreaRectangle(int arr[][]) {
		int length = arr[0].length;
		int maxArea = 0;
		int temp[] = new int[length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < length; j++) {
				if (arr[i][j] == 0) {
					temp[j] = arr[i][j];
				} else {
					temp[j] = temp[j] + arr[i][j];
				}
				int area = calculateArea(temp);
				maxArea = Math.max(maxArea, area);
			}
		}
		return maxArea;
	}

	public static int calculateArea(int input[]) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		int area = 0;
		int i;
		for (i = 0; i < input.length;) {
			if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
				stack.offerFirst(i++);
			} else {
				int top = stack.pollFirst();
				// if stack is empty means everything till i has to be
				// greater or equal to input[top] so get area by
				// input[top] * i;
				if (stack.isEmpty()) {
					area = input[top] * i;
				}
				// if stack is not empty then everythin from i-1 to input.peek() + 1
				// has to be greater or equal to input[top]
				// so area = input[top]*(i - stack.peek() - 1);
				else {
					area = input[top] * (i - stack.peekFirst() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pollFirst();
			// if stack is empty means everything till i has to be
			// greater or equal to input[top] so get area by
			// input[top] * i;
			if (stack.isEmpty()) {
				area = input[top] * i;
			}
			// if stack is not empty then everything from i-1 to input.peek() + 1
			// has to be greater or equal to input[top]
			// so area = input[top]*(i - stack.peek() - 1);
			else {
				area = input[top] * (i - stack.peekFirst() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int arr[][] = { { 1, 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1 }, { 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1 } };
		System.out.println(maxAreaRectangle(arr));
	}
}
