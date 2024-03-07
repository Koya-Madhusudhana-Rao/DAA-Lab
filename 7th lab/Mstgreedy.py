# Kruskal's Algorithm for Minimum Spanning Tree (MST)
# Using the Greedy approach

class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = []

    def add_edge(self, u, v, w):
        self.graph.append([u, v, w])

    def find(self, parent, i):
        if parent[i] == i:
            return i
        return self.find(parent, parent[i])

    def union(self, parent, rank, x, y):
        root_x = self.find(parent, x)
        root_y = self.find(parent, y)

        if rank[root_x] < rank[root_y]:
            parent[root_x] = root_y
        elif rank[root_x] > rank[root_y]:
            parent[root_y] = root_x
        else:
            parent[root_y] = root_x
            rank[root_x] += 1

    def kruskal_mst(self):
        result = []
        self.graph.sort(key=lambda item: item[2])
        parent = [i for i in range(self.V)]
        rank = [0] * self.V

        for u, v, w in self.graph:
            root_u = self.find(parent, u)
            root_v = self.find(parent, v)
            if root_u != root_v:
                result.append([u, v, w])
                self.union(parent, rank, root_u, root_v)

        return result

# Example usage:
g = Graph(4)
g.add_edge(0, 1, 10)
g.add_edge(0, 2, 6)
g.add_edge(0, 3, 5)
g.add_edge(1, 3, 15)
mst = g.kruskal_mst()
print("Minimum Spanning Tree edges:")
for u, v, w in mst:
    print(f"{u} - {v} : {w}")
