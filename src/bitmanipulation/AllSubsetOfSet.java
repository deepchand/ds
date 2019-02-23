package bitmanipulation;

import java.util.HashSet;
import java.util.Set;

public class AllSubsetOfSet {

	public static void findAllSubset(char arr[]) {
		int l = arr.length;
		int powSet = (int) Math.pow(2, l);
		for (int counter = 0; counter < powSet; counter++) {
			for (int j = 0; j < l; j++) {
				if ((counter & (1 << j)) > 0)
					System.out.print(arr[j]);
			}
			System.out.println();
		}
	}

	public static void printUniqueSubSet(char arr[]) {
		int l = arr.length;
		int powSet = (int) Math.pow(2, l);
		Set<String> set = new HashSet<>();
		for (int counter = 0; counter < powSet; counter++) {
			String temp = "";
			for (int j = 0; j < l; j++) {
				if ((counter & (1 << j)) > 0)
					temp = temp + (arr[j]) + ",";
				set.add(temp);
			}
		}
		set.forEach(t -> System.out.println(t));
	}

	public static void main(String[] args) {
		char arr[] = { '1', '1', '2' };
		printUniqueSubSet(arr);
	}
}
