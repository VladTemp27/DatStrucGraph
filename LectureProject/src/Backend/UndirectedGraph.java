package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph {
    private Map<String, List<String>> adjacencyList;

    public UndirectedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String vertex1, String vertex2) {
        if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
            List<String> edges1 = adjacencyList.get(vertex1);
            List<String> edges2 = adjacencyList.get(vertex2);

            edges1.add(vertex2);
            edges2.add(vertex1);
        } else {
            System.out.println("Invalid vertices");
        }
    }

    public List<String> getNeighbors(String vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }
}
