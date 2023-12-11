package Backend;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstTraversal {
    public static List<String> depthFirstTraversal(UndirectedGraph undirectedGraph, String startVertex) {
        List<String> visited = new ArrayList<>();
        depthFirstTraversalHelper(undirectedGraph, startVertex, visited);
        return visited;
    }

    private static void depthFirstTraversalHelper(UndirectedGraph undirectedGraph, String vertex, List<String> visited) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            for (String neighbor : undirectedGraph.getNeighbors(vertex)) {
                depthFirstTraversalHelper(undirectedGraph, neighbor, visited);
            }
        }
    }
}
