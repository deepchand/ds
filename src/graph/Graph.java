package graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {

	int V;
	List<Integer> adjListArray[];

	@SuppressWarnings("unchecked")
	Graph(int V) {
		this.V = V;
		adjListArray = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjListArray[i] = new LinkedList<>();
		}
	}

	public void addEdgeToUndirected(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
		graph.adjListArray[dest].add(src);
	}

	public void addEdgeToDirected(Graph graph, int src, int dest) {
		graph.adjListArray[src].add(dest);
	}

	void printGraph(Graph graph) {
		for (int v = 0; v < graph.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : graph.adjListArray[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}
}
