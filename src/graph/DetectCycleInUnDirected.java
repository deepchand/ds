package graph;

public class DetectCycleInUnDirected {

	public static int find(int parent[], int i) {
		if (parent[i] == -1)
			return i;
		return find(parent, parent[i]);
	}

	public static void union(int parent[], int x, int y) {
		int xParent = find(parent, x);
		int yParent = find(parent, y);
		parent[xParent] = yParent;
	}

	public static boolean isCycle(Graph graph) {
		int parent[] = new int[graph.V];
		for (int i = 0; i < graph.V; ++i)
			parent[i] = -1;
		for (int i = 0; i < graph.V; i++) {
			for (Integer j : graph.adjListArray[i]) {
				int x = find(parent, i);
				int y = find(parent, j);
				if (x == y)
					return true;
				union(parent, x, y);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Graph graph = new Graph(8);
		graph.addEdgeToUndirected(graph, 0, 1);
		graph.addEdgeToUndirected(graph, 1, 3);
		graph.addEdgeToUndirected(graph, 3, 2);
		graph.addEdgeToUndirected(graph, 1, 4);
		graph.addEdgeToUndirected(graph, 4, 5);
		graph.addEdgeToUndirected(graph, 5, 7);
		graph.addEdgeToUndirected(graph, 7, 6);
		if (isCycle(graph))
			System.out.println("graph contains cycle");
		else
			System.out.println("graph doesn't contain cycle");
	}
}
