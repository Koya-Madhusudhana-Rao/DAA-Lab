import java.util.*;

public class MaximumFlow {

    // Function to find the maximum flow using Ford-Fulkerson algorithm
    public static int fordFulkerson(int[][] graph, int source, int sink) {
        int n = graph.length; // Number of vertices in the graph
        int[][] residualGraph = new int[n][n]; // Residual graph

        // Initialize residual graph to be the same as original graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                residualGraph[i][j] = graph[i][j];
            }
        }

        int[] parent = new int[n]; // Parent array to store augmenting path
        int maxFlow = 0; // Initialize max flow

        // Augment the flow while there is a path from source to sink
        while (bfs(residualGraph, source, sink, parent)) {
            // Find minimum residual capacity of the augmenting path
            int pathFlow = Integer.MAX_VALUE;
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, residualGraph[u][v]);
            }

            // Update residual capacities of the edges and reverse edges along the path
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                residualGraph[u][v] -= pathFlow;
                residualGraph[v][u] += pathFlow;
            }

            // Add path flow to overall flow
            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    // Function to perform BFS to find augmenting path in residual graph
    private static boolean bfs(int[][] residualGraph, int source, int sink, int[] parent) {
        int n = residualGraph.length;
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < n; v++) {
                if (!visited[v] && residualGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return visited[sink];
    }

    public static void main(String[] args) {
        // Example problem: Maximum flow in a flow network
        int[][] graph = {
            {0, 16, 13, 0, 0, 0},
            {0, 0, 10, 12, 0, 0},
            {0, 4, 0, 0, 14, 0},
            {0, 0, 9, 0, 0, 20},
            {0, 0, 0, 7, 0, 4},
            {0, 0, 0, 0, 0, 0}
        };

        int source = 0;
        int sink = 5;

        int maxFlow = fordFulkerson(graph, source, sink);
        System.out.println("Maximum Flow: " + maxFlow);
    }
}
