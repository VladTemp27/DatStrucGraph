package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    public DirectedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String source, String destination) {
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            List<String> edges = adjacencyList.get(source);
            edges.add(destination);
        } else {
            System.out.println("Invalid vertices");
        }
    }

    public List<String> getNeighbors(String vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }
}

