package backtracing;

public class GraphColoring {

	public static final int V = 4;

	public static void printSolution(int color[], int vertex[]) {
		System.out.println("Following" + " are the assigned colors");

		for (int i = 0; i < V; i++) {
			System.out.print(" " + vertex[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < V; i++)
			System.out.print(" " + color[i] + " ");
		System.out.println();
	}

	public static boolean isSafe(int graph[][], int color[], int c, int v) {
		for (int i = 0; i < V; i++) {
			if (graph[v][i] == 1 && c == color[i])
				return false;
		}
		return true;
	}

	public static void graphColorUtil(int graph[][], int m, int v, int color[], int vertex[]) {
		if (v == V) {
			printSolution(color, vertex);
			return ;
		}

		for (int c = 1; c <= m; c++) {

			if (isSafe(graph, color, c, v)) {
				color[v] = c;
				vertex[v] = v;
				graphColorUtil(graph, m, v + 1, color, vertex);

				color[v] = 0;
				vertex[v] = 0;
			}
		}
	}

	public static boolean graphColoring(int graph[][], int m) {
		// Initialize all color values as 0. This
		// initialization is needed correct functioning
		// of isSafe()
		int color[] = new int[V];
		int vertex[] = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = 0;
		// Call graphColoringUtil() for vertex 0
		graphColorUtil(graph, m, 0, color, vertex);
		// Print the solution
		printSolution(color, vertex);
		return true;
	}

	public static void main(String[] args) {
		int graph[][] = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int m = 3;
		graphColoring(graph, m);
	}
}
