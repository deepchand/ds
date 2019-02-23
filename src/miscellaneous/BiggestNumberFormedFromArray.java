package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BiggestNumberFormedFromArray {
	public static void printLargest(List<String> arr) {

		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String o1o2 = o1 + o2;
				String o2o1 = o2 + o1;
				return o2o1.compareTo(o1o2);
			}
		});
		Iterator<String> it = arr.iterator();

		while (it.hasNext())
			System.out.print(it.next());

	}

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		printLargest(arr);
	}
}
