package greedy;

public class PrimsMst {

	public static int minDistance(boolean mstSet[], int dist[], int v) {
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for (int i = 0; i < v; i++) {
			if (!mstSet[i] && dist[i] < min) {
				min = dist[i];
				min_index = i;
			}
		}
		return min_index;
	}

	public static void printMST(int parent[], int v, int graph[][]) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < v; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}

	public static void primsMst(int graph[][], int v) {
		int parent[] = new int[v];
		int dist[] = new int[v];
		boolean mstSet[] = new boolean[v];
		for (int i = 0; i < v; i++) {
			mstSet[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		parent[0] = -1;
		for (int count = 0; count < v - 1; count++) {
			int u = minDistance(mstSet, dist, v);
			mstSet[u] = true;
			for (int vertex = 0; vertex < v; vertex++) {
				if (!mstSet[vertex] && graph[u][vertex] != 0 && graph[u][vertex] < dist[vertex]) {
					parent[vertex] = u;
					dist[vertex] = graph[u][vertex];
				}
			}
		}
		printMST(parent, v, graph);
	}

	public static void main(String[] args) {

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 2, 0 }, { 0, 0, 7, 0, 9, 11, 0, 0, 0 }, { 0, 0, 0, 9, 0, 1, 0, 0, 0, },
				{ 0, 0, 4, 14, 0, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		// Print the solution
		primsMst(graph, 9);
	}
}
