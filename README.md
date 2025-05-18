# Graph Implementation with Vertex Objects
This project implements a weighted graph data structure using vertex objects instead of edge objects, along with Breadth-First Search (BFS) and Dijkstra's algorithm implementations for pathfinding.

## Classes Overview
### 1. `Vertex<V>` Class

**Purpose**: Represents a vertex in the graph with its adjacent vertices and edge weights.
**Fields**:
- `data`: The value stored in the vertex (generic type V)
- `adjacentVertices`: A map of adjacent vertices to their edge weights

**Key Methods**:
- `addAdjacentVertex(Vertex<V> destination, double weight)`: Adds a connection to another vertex with a specified weight
- `getData()`: Returns the vertex's data
- `getAdjacentVertices()`: Returns all adjacent vertices with their weights

### 2. `WeightedGraph<V>` Class

**Purpose**: Represents a weighted undirected graph using vertex objects.

**Fields**:
- `vertices`: A map of vertex data to Vertex objects

**Key Methods**:
- `addVertex(V data)`: Adds a new vertex to the graph
- `addEdge(V source, V dest, double weight)`: Adds a weighted edge between two vertices (bidirectional)
- `getVertex(V data)`: Retrieves a vertex by its data
- `getVertices()`: Returns all vertex data in the graph

### 3. `Search<V>` Interface

**Purpose**: Defines the common interface for search algorithms.

**Key Method**:
- `pathTo(V destination)`: Returns the path from source to destination

### 4. `BreadthFirstSearch<V>` Class

**Purpose**: Implements BFS for unweighted pathfinding.

**Fields**:
- `edgeTo`: Tracks the path to each vertex
- `marked`: Tracks visited vertices
- `source`: The starting vertex

**Key Methods**:
- `bfs(WeightedGraph<V> graph, V source)`: Performs BFS traversal
- `pathTo(V destination)`: Returns the BFS path to destination

### 5. `DijkstraSearch<V>` Class

**Purpose**: Implements Dijkstra's algorithm for shortest path finding in weighted graphs.

**Fields**:
- `distTo`: Tracks minimum distance to each vertex
- `edgeTo`: Tracks the path to each vertex
- `pq`: Priority queue for Dijkstra's algorithm
- `marked`: Tracks visited vertices
- `source`: The starting vertex

**Key Methods**:
- `relax(WeightedGraph<V> graph, V v)`: Relaxes edges during Dijkstra's algorithm
- `pathTo(V destination)`: Returns the shortest path to destination
- `distTo(V destination)`: Returns the shortest distance to destination

## Example Usage

```java
WeightedGraph<String> graph = new WeightedGraph<>();
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addEdge("A", "B", 5.0);
graph.addEdge("B", "C", 3.0);

// BFS example
BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "A");
System.out.println(bfs.pathTo("C")); // [A, B, C]

// Dijkstra's example
DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "A");
System.out.println(dijkstra.pathTo("C")); // [A, B, C]
System.out.println(dijkstra.distTo("C")); // 8.0
