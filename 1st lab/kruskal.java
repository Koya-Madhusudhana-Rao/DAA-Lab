import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class KruskalAlgorithm {

    // Function to find the minimum spanning tree using Kruskal's algorithm
    public static void kruskalMST(int vertices, Edge[] edges) {
        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        System.out.println("Edge   Weight");
        for (Edge edge : edges) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

            if (rootSrc != rootDest) {
                System.out.println(edge.src + " - " + edge.dest + "    " + edge.weight);
                union(parent, rootSrc, rootDest);
            }
        }
    }

    // Function to find the root of a set using path compression
    private static int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent, parent[vertex]);
        }
        return parent[vertex];
    }

    // Function to perform union of two sets
    private static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootX] = rootY;
    }

    // Example usage
    public static void main(String[] args) {
        int vertices = 5;
        Edge[] edges = {
                new Edge(0, 1, 2),
                new Edge(0, 3, 6),
                new Edge(1, 2, 3),
                new Edge(1, 3, 8),
                new Edge(1, 4, 5),
                new Edge(2, 4, 7),
                new Edge(3, 4, 9)
        };

        kruskalMST(vertices, edges);
    }
}
