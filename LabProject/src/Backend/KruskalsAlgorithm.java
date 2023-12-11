package Backend;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {
    public static List<Edge> kruskalsAlgorithm(List<Edge> edges, List<Vertex> vertices) {
        List<Edge> mutableEdges = new ArrayList<>(List.copyOf(edges)); // Create a mutable copy

        List<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet();

        for (Vertex vertex : vertices) {
            disjointSet.makeSet(vertex);
        }

        mutableEdges.sort(Comparator.comparingDouble(Edge::getWeight));

        for (Edge edge : mutableEdges) {
            Vertex startVertex = edge.getStart();
            Vertex endVertex = edge.getEnd();

            if (disjointSet.find(startVertex) != disjointSet.find(endVertex)) {
                minimumSpanningTree.add(edge);
                disjointSet.union(startVertex, endVertex);
            }
        }

        return minimumSpanningTree;
    }
}
