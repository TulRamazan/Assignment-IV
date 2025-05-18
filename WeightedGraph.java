import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class WeightedGraph<V> {
    Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {
        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        if (sourceVertex != null && destVertex != null) {
            sourceVertex.addAdjacentVertex(destVertex, weight);
            destVertex.addAdjacentVertex(sourceVertex, weight); // for undirected graph
        }
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Set<V> getVertices() {
        return vertices.keySet();
    }
}