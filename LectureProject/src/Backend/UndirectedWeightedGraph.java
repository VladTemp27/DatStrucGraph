package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedWeightedGraph {
    private Map<String, List<Edge>> adjacencyList;

    public UndirectedWeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            List<Edge> edgesSource = adjacencyList.get(source);
            List<Edge> edgesDestination = adjacencyList.get(destination);

            edgesSource.add(new Edge(destination, weight));
            edgesDestination.add(new Edge(source, weight));
        } else {
            System.out.println("Invalid vertices");
        }
    }

    public List<String> getVertices() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    public Map<String, Integer> getNeighborsWithWeights(String vertex) {
        Map<String, Integer> neighborsWithWeights = new HashMap<>();
        List<Edge> edges = adjacencyList.get(vertex);

        for (Edge edge : edges) {
            neighborsWithWeights.put(edge.destination, edge.weight);
        }

        return neighborsWithWeights;
    }

    private static class Edge {
        String destination;
        int weight;

        public Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
