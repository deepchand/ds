package graph;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleInDirectedGraph {

	public static boolean isCycle(Graph graph) {
		Set<Integer> whiteSet = new HashSet<>();
		Set<Integer> graySet = new HashSet<>();
		Set<Integer> blackSet = new HashSet<>();
		for (int i = 0; i < graph.adjListArray.length; i++) {
			whiteSet.add(i);
		}
		for (int i = 0; i < graph.V; i++) {
			if (whiteSet.contains(i) && isCycleUtil(i, whiteSet, graySet, blackSet, graph))
				return true;
		}
		return false;
	}

	private static boolean isCycleUtil(int vertex, Set<Integer> whiteSet, Set<Integer> graySet, Set<Integer> blackSet,
			Graph graph) {
		whiteSet.remove(vertex);
		graySet.add(vertex);
		for (int i = 0; i < graph.adjListArray[vertex].size(); i++) {
			int adjVertex = graph.adjListArray[vertex].get(i);
			if (graySet.contains(adjVertex)) {
				return true;
			}
			if (blackSet.contains(adjVertex))
				continue;
			if (isCycleUtil(adjVertex, whiteSet, graySet, blackSet, graph))
				return true;
		}
		graySet.remove(vertex);
		blackSet.add(vertex);
		return false;
	}

	public static void main(String[] args) {
		int vertices = 8;
		Graph graph = new Graph(vertices);
		graph.addEdgeToDirected(graph, 0, 1);
		graph.addEdgeToDirected(graph, 1, 2);
		graph.addEdgeToDirected(graph, 2, 3);
	    graph.addEdgeToDirected(graph, 3, 0);
		graph.addEdgeToDirected(graph, 3, 4);
		graph.addEdgeToDirected(graph, 4, 5);
		graph.addEdgeToDirected(graph, 5, 6);
		graph.addEdgeToDirected(graph, 6, 7);
		// graph.addEdgeToDirected(graph, 7, 4);
		System.out.println(isCycle(graph));
	}

}
