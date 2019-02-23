package recursion;

/*Given a number line from-infinity to+infinity.
You start at 0 and can go either to the left or 
to the right.The condition is that in i’th move,
you take i steps.a)Find if you can reach a given 
number x b)Find the most optimal way to reach a
given number x,if we can indeed reach it.
For example,3 can be reached in 2 steps,(0,1)(1,3)and
4 can be reached in 3 steps(0,-1),(-1,1)(1,4)*/
public class NumOfStepToReachDestination {

	public static int countMinimumNumberOfSteps(int src, int steps, int des) {
		if (Math.abs(src) > des)
			return Integer.MAX_VALUE;
		if (src == des)
			return steps;
		int pos = countMinimumNumberOfSteps(src + steps + 1, steps + 1, des);
		int neg = countMinimumNumberOfSteps(src - steps - 1, steps + 1, des);
		return Math.min(pos, neg);
	}
	public static int countSteps(int des) {
		return countMinimumNumberOfSteps(0, 0, des);
	}
	public static void main(String[] args) {
		System.out.println(countSteps(11));
	}
}
