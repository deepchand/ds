package graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	public static void topologicalSort(Graph graph) {
		boolean visited[] = new boolean[graph.V];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < graph.V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack, graph);
			}
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack, Graph graph) {
		visited[vertex] = true;
		Iterator<Integer> it = graph.adjListArray[vertex].iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (!visited[i]) {
				topologicalSortUtil(i, visited, stack, graph);
			}
		}
		stack.push(vertex);
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addEdgeToDirected(graph, 5, 2);
		graph.addEdgeToDirected(graph, 5, 0);
		graph.addEdgeToDirected(graph, 4, 0);
		graph.addEdgeToDirected(graph, 4, 1);
		graph.addEdgeToDirected(graph, 2, 3);
		graph.addEdgeToDirected(graph, 3, 1);
		System.out.println("Following is a Topological " + "sort of the given graph");
		TopologicalSort.topologicalSort(graph);
	}
}
