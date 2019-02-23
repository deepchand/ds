package recursion;


// Return the mth value from nth row 
//where rows and column starts from 0
/*
        1
      1    1
    1   2   1
   1  3   3   1
 1  4   6   4  1*/
 
public class Combinatorics {

	public static int combination(int n, int m) {
		if (n == 0 || m == 0 || n == m) {
			return 1;
		} else {
			return combination(n - 1, m) + combination(n - 1, m - 1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(combination(5, 4));
	}
}
