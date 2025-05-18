import java.util.*;
public class DijkstraSearch<V> implements Search<V> {
     Map<V, Double> distTo;
     Map<V, V> edgeTo;
     PriorityQueue<VertexDistance<V>> pq;
     Set<V> marked;
    private final V source;
    private static class VertexDistance<V> implements Comparable<VertexDistance<V>> {
        V vertex;
        double distance;
        VertexDistance(V vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(VertexDistance<V> other) {
            return Double.compare(this.distance, other.distance);
        }
    }

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        this.source = source;
        this.distTo = new HashMap<>();
        this.edgeTo = new HashMap<>();
        this.marked = new HashSet<>();
        this.pq = new PriorityQueue<>();

        for (V v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(source, 0.0);

        pq.add(new VertexDistance<>(source, 0.0));
        while (!pq.isEmpty()) {
            V v = pq.poll().vertex;
            if (marked.contains(v)) continue;
            marked.add(v);
            relax(graph, v);
        }
    }
    private void relax(WeightedGraph<V> graph, V v) {
        Vertex<V> vertex = graph.getVertex(v);
        for (Map.Entry<Vertex<V>, Double> entry : vertex.getAdjacentVertices().entrySet()) {
            V w = entry.getKey().getData();
            double weight = entry.getValue();

            if (distTo.get(w) > distTo.get(v) + weight) {
                distTo.put(w, distTo.get(v) + weight);
                edgeTo.put(w, v);
                pq.add(new VertexDistance<>(w, distTo.get(w)));
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
    public double distTo(V destination) {
        return distTo.getOrDefault(destination, Double.POSITIVE_INFINITY);
    }
}