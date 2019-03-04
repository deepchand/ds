package miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvexHullProblem {
	public static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static List<Point> findBoundry(Point points[]) {
		// first find leftmost point to start the march.
		Point start = points[0];
		for (int i = 1; i < points.length; i++) {
			if (points[i].x < start.x) {
				start = points[i];
			}
		}
		Point current = start;
		// use set because this algorithm might try to insert duplicate point.
		Set<Point> result = new HashSet<>();
		result.add(start);
		List<Point> collinearPoints = new ArrayList<>();
		while (true) {
			Point nextTarget = points[0];
			for (int i = 1; i < points.length; i++) {
				if (points[i] == current) {
					continue;
				}
				int val = crossProduct(current, nextTarget, points[i]);
				// if val > 0 it means points[i] is on left of current -> nextTarget. Make him
				// the nextTarget.
				if (val > 0) {
					nextTarget = points[i];
					// reset collinear points because we now have a new nextTarget.
					collinearPoints = new ArrayList<>();
				} else if (val == 0) { // if val is 0 then collinear current, nextTarget and points[i] are collinear.
					// if its collinear point then pick the further one but add closer one to list
					// of collinear points.
					if (distance(current, nextTarget, points[i]) < 0) {
						collinearPoints.add(nextTarget);
						nextTarget = points[i];
					} else { // just add points[i] to collinearPoints list. If nextTarget indeed is the next
								// point on
						// convex then all points in collinear points will be also on boundary.
						collinearPoints.add(points[i]);
					}
				}
				// else if val < 0 then nothing to do since points[i] is on right side of
				// current -> nextTarget.
			}

			// add all points in collinearPoints to result.
			for (Point p : collinearPoints) {
				result.add(p);
			}
			// if nextTarget is same as start it means we have formed an envelope and its
			// done.
			if (nextTarget == start) {
				break;
			}
			// add nextTarget to result and set current to nextTarget.
			result.add(nextTarget);
			current = nextTarget;
		}
		return new ArrayList<>(result);
	}

	/**
	 * Returns < 0 if 'b' is closer to 'a' compared to 'c', == 0 if 'b' and 'c' are
	 * same distance from 'a' or > 0 if 'c' is closer to 'a' compared to 'b'.
	 */
	private static int distance(Point a, Point b, Point c) {
		int y1 = a.y - b.y;
		int y2 = a.y - c.y;
		int x1 = a.x - b.x;
		int x2 = a.x - c.x;
		return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
	}

	/**
	 * Cross product to find where c belongs in reference to vector ab. If result >
	 * 0 it means 'c' is on left of ab result == 0 it means 'a','b' and 'c' are
	 * collinear result < 0 it means 'c' is on right of ab
	 */
	private static int crossProduct(Point a, Point b, Point c) {
		int y1 = a.y - b.y;
		int y2 = a.y - c.y;
		int x1 = a.x - b.x;
		int x2 = a.x - c.x;
		return y2 * x1 - y1 * x2;
	}

	public static void main(String[] args) {
		Point points[] = new Point[7];
		points[0] = new Point(0, 3);
		points[1] = new Point(2, 3);
		points[2] = new Point(1, 1);
		points[3] = new Point(2, 1);
		points[4] = new Point(3, 0);
		points[5] = new Point(0, 0);
		points[6] = new Point(3, 3);
		List<Point> list = findBoundry(points);
		list.forEach(p -> {
			System.out.println(p.x + "," + p.y);
		});
	}
}
