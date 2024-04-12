import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private int uSize; // Number of vertices in set U
    private int vSize; // Number of vertices in set V
    private ArrayList<ArrayList<Integer>> adj; // Adjacency list
    private int[] pairU, pairV; // Pairing arrays
    private int[] dist; // Distance array

    public BipartiteGraph(int uSize, int vSize) {
        this.uSize = uSize;
        this.vSize = vSize;
        adj = new ArrayList<>(uSize + 1);
        for (int i = 0; i <= uSize; i++) {
            adj.add(new ArrayList<>());
        }
        pairU = new int[uSize + 1];
        pairV = new int[vSize + 1];
        dist = new int[uSize + 1];
    }

    // Add an edge between vertex u in set U and vertex v in set V
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    // BFS to find augmenting path
    private boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int u = 1; u <= uSize; u++) {
            if (pairU[u] == 0) {
                dist[u] = 0;
                queue.add(u);
            } else {
                dist[u] = Integer.MAX_VALUE;
            }
        }
        dist[0] = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (dist[u] < dist[0]) {
                for (int v : adj.get(u)) {
                    if (dist[pairV[v]] == Integer.MAX_VALUE) {
                        dist[pairV[v]] = dist[u] + 1;
                        queue.add(pairV[v]);
                    }
                }
            }
        }
        return dist[0] != Integer.MAX_VALUE;
    }

    // DFS to find augmenting path
    private boolean dfs(int u) {
        if (u != 0) {
            for (int v : adj.get(u)) {
                if (dist[pairV[v]] == dist[u] + 1) {
                    if (dfs(pairV[v])) {
                        pairV[v] = u;
                        pairU[u] = v;
                        return true;
                    }
                }
            }
            dist[u] = Integer.MAX_VALUE;
            return false;
        }
        return true;
    }

    // Hopcroft-Karp algorithm for maximum matching in bipartite graph
    public int maximumMatching() {
        int maxMatching = 0;
        while (bfs()) {
            for (int u = 1; u <= uSize; u++) {
                if (pairU[u] == 0 && dfs(u)) {
                    maxMatching++;
                }
            }
        }
        return maxMatching;
    }

    public static void main(String[] args) {
        BipartiteGraph graph = new BipartiteGraph(4, 4);

        // Add edges between set U and set V
        graph.addEdge(1, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 2);
        graph.addEdge(3, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 4);

        // Find maximum matching
        int maxMatching = graph.maximumMatching();
        System.out.println("Maximum Matching: " + maxMatching);
    }
}
