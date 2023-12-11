package Backend;

import java.util.*;

public class PrimsAlgorithm {
    public static List<Edge> prim(List<Edge> edges, List<Vertex> vertices) {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        Set<Vertex> visitedVertices = new HashSet<>();

        // Choose a starting vertex (for example, the first one)
        Vertex startVertex = vertices.get(0);
        visitedVertices.add(startVertex);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(Edge::getWeight));
        priorityQueue.addAll(getEdgesForVertex(edges, startVertex));

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();

            Vertex nextVertex = currentEdge.getEnd();
            if (!visitedVertices.contains(nextVertex)) {
                visitedVertices.add(nextVertex);
                minimumSpanningTree.add(currentEdge);

                // Add edges of the next vertex to the priority queue
                priorityQueue.addAll(getEdgesForVertex(edges, nextVertex));
            }
        }

        return minimumSpanningTree;
    }

    private static List<Edge> getEdgesForVertex(List<Edge> edges, Vertex vertex) {
        List<Edge> edgesForVertex = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)) {
                edgesForVertex.add(edge);
            }
        }
        return edgesForVertex;
    }
}

