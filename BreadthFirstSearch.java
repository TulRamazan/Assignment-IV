import java.util.*;
public class BreadthFirstSearch<V> implements Search<V> {
    private Map<V, V> edgeTo;
    private Set<V> marked;
    private final V source;
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        this.source = source;
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        bfs(graph, source);
    }
    private void bfs(WeightedGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);

        while (!queue.isEmpty()) {
            V current = queue.poll();
            Vertex<V> vertex = graph.getVertex(current);

            for (Vertex<V> neighbor : vertex.getAdjacentVertices().keySet()) {
                V neighborData = neighbor.getData();
                if (!marked.contains(neighborData)) {
                    edgeTo.put(neighborData, current);
                    marked.add(neighborData);
                    queue.add(neighborData);
                }
            }
        }
    }
    @Override
    public List<V> pathTo(V destination) {
        if (!marked.contains(destination)) return Collections.emptyList();
        List<V> path = new LinkedList<>();
        for (V x = destination; x != null && !x.equals(source); x = edgeTo.get(x)) {
            path.add(0, x);
        }
        path.add(0, source);
        return path;
    }
}