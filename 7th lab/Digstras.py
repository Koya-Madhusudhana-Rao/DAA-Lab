# Dijkstra's Algorithm for Single Source Shortest Path
# Using the Greedy approach

import heapq

class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, u, v, w):
        self.graph[u].append((v, w))

    def dijkstra(self, src):
        dist = [float('inf')] * self.V
        dist[src] = 0
        pq = [(0, src)]

        while pq:
            d, u = heapq.heappop(pq)
            for v, w in self.graph[u]:
                if dist[v] > dist[u] + w:
                    dist[v] = dist[u] + w
                    heapq.heappush(pq, (dist[v], v))

        return dist

# Example usage:
g = Graph(5)
g.add_edge(0, 1, 10)
g.add_edge(0, 2, 5)
g.add_edge(1, 3, 2)
g.add_edge(2, 1, 3)
g.add_edge(2, 3, 9)
shortest_paths = g.dijkstra(0)
print("Shortest paths from vertex 0:")
for i, dist in enumerate(shortest_paths):
    print(f"Vertex {i}: {dist}")
