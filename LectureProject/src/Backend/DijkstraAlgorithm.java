package Backend;

import java.util.*;

public class DijkstraAlgorithm {
    public static Map<String, Integer> dijkstra(UndirectedWeightedGraph graph, String startVertex) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (String vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }

        distances.put(startVertex, 0);
        priorityQueue.add(new Node(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();

            for (Map.Entry<String, Integer> neighborEntry : graph.getNeighborsWithWeights(currentNode.vertex).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int newDistance = distances.get(currentNode.vertex) + neighborEntry.getValue();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    priorityQueue.add(new Node(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    private static class Node {
        String vertex;
        int distance;

        public Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
