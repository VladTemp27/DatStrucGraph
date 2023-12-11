package Backend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstTraversal {
    public static List<String> breadthFirstTraversal(UndirectedGraph undirectedGraph, String startVertex) {
        List<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            for (String neighbor : undirectedGraph.getNeighbors(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return visited;
    }
}
