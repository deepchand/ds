package miscellaneous;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {

	static Deque<Integer> dq = new LinkedList<>();
	static Set<Integer> set = new HashSet<>();
	static final int cacheSize = 4;

	public static void refer(int x) {
		if (!set.contains(x)) {
			if (dq.size() == cacheSize) {
				int last = dq.removeLast();
				set.remove(last);
			}
		} else {
			dq.remove(x);
		}
		dq.push(x);
		set.add(x);
	}

	public static void display() {
		Iterator<Integer> itr = dq.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		refer(1);
		refer(2);
		refer(3);
		refer(1);
		refer(4);
		refer(5);
		display();
	}
}
