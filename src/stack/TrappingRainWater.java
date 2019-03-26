package stack;

import java.util.Stack;

//Java program to find maximum amount of water that can 
//be trapped within given set of bars. 
public class TrappingRainWater {

	public static int maxWater(int arr[]) {

		if (arr.length == 1)
			return 0;

		Stack<Integer> stack = new Stack<>();

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				int top = stack.pop();
				int dist = i - stack.peek() - 1;
				int bounded_h = Math.min(arr[i], arr[stack.peek()]) - arr[top];
				ans += dist * bounded_h;
			}
			stack.push(i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,5,4,7,8,0,3};
		System.out.println(maxWater(arr));
	}
}
