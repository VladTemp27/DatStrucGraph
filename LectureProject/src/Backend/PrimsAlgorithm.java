package Backend;

import java.util.*;

public class PrimsAlgorithm {
    public static List<EdgeLEC> prim(List<EdgeLEC> edges, List<VertexLEC> vertices) {
        List<EdgeLEC> minimumSpanningTree = new ArrayList<>();
        Set<VertexLEC> visitedVertices = new HashSet<>();

        // Choose a starting vertex (for example, the first one)
        VertexLEC startVertex = vertices.get(0);
        visitedVertices.add(startVertex);

        PriorityQueue<EdgeLEC> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(EdgeLEC::getWeight));
        priorityQueue.addAll(getEdgesForVertex(edges, startVertex));

        while (!priorityQueue.isEmpty()) {
            EdgeLEC currentEdge = priorityQueue.poll();

            VertexLEC nextVertex = currentEdge.getEnd();
            if (!visitedVertices.contains(nextVertex)) {
                visitedVertices.add(nextVertex);
                minimumSpanningTree.add(currentEdge);

                // Add edges of the next vertex to the priority queue
                priorityQueue.addAll(getEdgesForVertex(edges, nextVertex));
            }
        }

        return minimumSpanningTree;
    }

    private static List<EdgeLEC> getEdgesForVertex(List<EdgeLEC> edges, VertexLEC vertex) {
        List<EdgeLEC> edgesForVertex = new ArrayList<>();
        for (EdgeLEC edge : edges) {
            if (edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)) {
                edgesForVertex.add(edge);
            }
        }
        return edgesForVertex;
    }
}
