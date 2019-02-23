package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInAStreamOfData {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public static void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.peek());
		maxHeap.remove();

		if (maxHeap.size() < minHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	public static double findMedian(int num) {
		addNum(num);
		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + (minHeap.peek())) / 2;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		int arr[] = { 41, 35, 62, 5, 97, 108 };
		for (int i = 0; i < arr.length; i++) {
          System.out.print(findMedian(arr[i])+" ");
		}
	}
}
