package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

	static class Job {
		int dead;
		Integer profits;
		char id;

		public Job(int dead, int profits, char id) {
			super();
			this.dead = dead;
			this.profits = profits;
			this.id = id;
		}
	}

	public static void printJobScheduling(int profits[], int dead[], char id[]) {

		Job job[] = new Job[profits.length];
		Job result[] = new Job[profits.length];
		boolean slot[] = new boolean[profits.length];
		for (int i = 0; i < profits.length; i++) {
			job[i] = new Job(dead[i], profits[i], id[i]);
		}

		Arrays.sort(job, new Comparator<Job>() {
			@Override
			public int compare(Job o1, Job o2) {
				return o2.profits.compareTo(o1.profits);
			}
		});
		for (int i = 0; i < job.length; i++) {
			for (int j = Math.min(profits.length, job[i].dead) - 1; j >= 0; j--) {
				if (slot[j] == false) {
					result[j] = job[i];
					slot[j] = true;
					break;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			if(slot[i])
			System.out.print(result[i].id + " ");
		}
	}

	public static void main(String[] args) {
		int profits[] = { 15, 20, 10, 5, 1 };
		int dead[] = { 2, 2, 1, 3, 3 };
		char id[] = { 'b', 'a', 'c', 'd', 'e' };
		printJobScheduling(profits, dead, id);
	}
}
