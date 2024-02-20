import java.util.Arrays;

public class prims {

    // Function to find the minimum spanning tree using Prim's algorithm
    public static void primMST(int[][] graph) {
        int vertices = graph.length;

        // Arra y to store the parent of each vertex in the MST
        int[] parent = new int[vertices];

        // Array to store the key values of each vertex
        int[] key = new int[vertices];

        // Array to keep track of whether a vertex is included in the MST
        boolean[] mstSet = new boolean[vertices];

        // Initialize key values to infinity and mstSet to false
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);

        // Start with the first vertex
        key[0] = 0;
        parent[0] = -1;

        // Construct the MST
        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            // Update key values and parent for adjacent vertices of the chosen vertex
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Print the MST
        System.out.println("Edge   Weight");
        for (int i = 1; i < vertices; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }

    // Function to find the vertex with the minimum key value
    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        int vertices = key.length;

        for (int v = 0; v < vertices; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Example usage
    public static void main(String[] args) {
        int[][] graph = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        primMST(graph);
    }
}
