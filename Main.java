public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        // Add vertices
        for (String city : new String[]{"New York", "Chicago", "Denver", "Los Angeles", "Kansas City"}) {
            graph.addVertex(city);
        }
        // Add edges
        graph.addEdge("New York", "Chicago", 5.0);
        graph.addEdge("New York", "Denver", 15.0);
        graph.addEdge("Chicago", "Denver", 7.0);
        graph.addEdge("Chicago", "Kansas City", 10.0);
        graph.addEdge("Denver", "Kansas City", 5.0);
        graph.addEdge("Denver", "Los Angeles", 20.0);
        graph.addEdge("Kansas City", "Los Angeles", 12.0);
        // BFS example
        System.out.println("BFS Path from New York to Los Angeles:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, "New York");
        System.out.println(bfs.pathTo("Los Angeles"));
        // Dijkstra's example
        System.out.println("\nDijkstra's Path from New York to Los Angeles:");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, "New York");
        System.out.println(dijkstra.pathTo("Los Angeles"));
        System.out.println("Total distance: " + dijkstra.distTo("Los Angeles"));
    }
}