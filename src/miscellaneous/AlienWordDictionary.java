package miscellaneous;

import java.util.LinkedList;
import java.util.Stack;

public class AlienWordDictionary {

	public static class Graph {
		private final LinkedList<Integer>[] adjacencyList;

		Graph(int nVertices) {
			adjacencyList = new LinkedList[nVertices];
			for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
				adjacencyList[vertexIndex] = new LinkedList<>();
			}
		}

		// function to add an edge to graph
		void addEdge(int startVertex, int endVertex) {
			adjacencyList[startVertex].add(endVertex);
		}

		private int getNoOfVertices() {
			return adjacencyList.length;
		}

		public void topologicalSort() {
			boolean visited[] = new boolean[getNoOfVertices()];
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < getNoOfVertices(); i++) {
				if (!visited[i]) {
					topologicalSortUtil(i, visited, stack);
				}
			}
			while (!stack.isEmpty()) {
				System.out.print((char) ('a' + stack.pop()) + " ");
			}
		}

		private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
			visited[vertex] = true;
			for (int adjVertex : adjacencyList[vertex]) {
				if (!visited[adjVertex]) {
					topologicalSortUtil(adjVertex, visited, stack);
				}
			}
			stack.push(vertex);
		}
	}

	public static void printOrder(String words[], int alpha) {
		Graph graph = new Graph(alpha);
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				if (word1.charAt(j) != word2.charAt(j)) {
					graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
					break;
				}
			}
		}
		graph.topologicalSort();
	}

	public static void main(String[] args) {
		String[] words = { "baa", "abcd", "abca", "cab", "cad" };
		printOrder(words, 4);
	}
}
