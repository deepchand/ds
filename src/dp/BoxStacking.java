package dp;

import java.util.Arrays;

/**
 * Date 15/03/2019
 * 
 * @author deepchandswami
 * 
 *         Given different dimensions and unlimited supply of boxes for each
 *         dimension, stack boxes on top of each other such that it has maximum
 *         height but with caveat that length and width of box on top should be
 *         strictly less than length and width of box under it. You can rotate
 *         boxes as you like.
 * 
 *         1) Create all rotations of boxes such that length is always greater
 *         or equal to width 2) Sort boxes by base area in non increasing order
 *         (length * width). This is because box with more area will never ever
 *         go on top of box with less area. 3) Take T[] and result[] array of
 *         same size as total boxes after all rotations are done 4) Apply
 *         longest increasing subsequence type of algorithm to get max height.
 * 
 *         If n number of dimensions are given total boxes after rotation will
 *         be 3n. So space complexity is O(n) Time complexity - O(nlogn) to sort
 *         boxes. O(n^2) to apply DP on it So really O(n^2)
 *
 *         References
 *         http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
 *         http://people.cs.clemson.edu/~bcdean/dp_practice/
 */

public class BoxStacking {

	public static class Box implements Comparable<Box> {

		int height;
		int length;
		int width;

		public Box(int height, int length, int width) {
			super();
			this.height = height;
			this.length = length;
			this.width = width;
		}

		public Box() {
		}

		public static Box createBox(int height, int side1, int side2) {
			Box box = new Box();
			box.height = height;
			if (side1 > side2) {
				box.length = side1;
				box.width = side2;
			} else {
				box.length = side2;
				box.width = side1;
			}
			return box;
		}

		@Override
		public int compareTo(Box o) {
			if (this.length * this.width > o.length * o.width)
				return -1;
			else
				return 1;
		}

		@Override
		public String toString() {
			return "Box [height=" + height + ", length=" + length + ", width=" + width + "]";
		}
	}

	// create all rotations of boxes, always keeping length greater or equal to
	// width
	private void createAllRotations(Box[] input, Box allRotation[]) {
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			allRotation[index++] = Box.createBox(input[i].height, input[i].length, input[i].width);
			allRotation[index++] = Box.createBox(input[i].length, input[i].height, input[i].width);
			allRotation[index++] = Box.createBox(input[i].width, input[i].length, input[i].height);
		}
	}

	public int maxHeight(Box[] input) {
		// get all rotations of box dimension.
		// e.g if dimension is 1,2,3 rotations will be 2,1,3 3,2,1 3,1,2 . Here length
		// is always greater
		// or equal to width and we can do that without loss of generality.

		Box allRotation[] = new Box[3 * input.length];
		createAllRotations(input, allRotation);

		Arrays.sort(allRotation);

		int t[] = new int[allRotation.length];
		int result[] = new int[allRotation.length];

		for (int i = 0; i < t.length; i++) {
			t[i] = allRotation[i].height;
			result[i] = i;
		}

		for (int i = 1; i < allRotation.length; i++) {
			for (int j = 0; j < i; j++) {

				if (allRotation[i].length < allRotation[j].length && allRotation[i].width < allRotation[j].width) {

					if (t[j] + allRotation[i].height > t[i]) {
						t[i] = t[j] + allRotation[i].height;
						result[i] = j;
					}
				}
			}
		}

		// find max in t[] and that will be our max height.
		// Result can also be found using result[] array.
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < t.length; i++) {
			if (t[i] > max) {
				max = t[i];
			}
		}

		return max;
	}

	public static void main(String args[]) {
		BoxStacking bs = new BoxStacking();
		Box input[] = { new Box(4, 6, 7), new Box(1, 2, 3), new Box(4, 5, 6), new Box(10, 12, 32) };
		int maxHeight = bs.maxHeight(input);
		System.out.println("Max height is " + maxHeight);
	}
}
