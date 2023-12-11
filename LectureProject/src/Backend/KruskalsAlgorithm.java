package Backend;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {
    public static List<EdgeLEC> kruskalsAlgorithm(List<EdgeLEC> edges, List<VertexLEC> vertices) {
        List<EdgeLEC> mutableEdges = new ArrayList<>(List.copyOf(edges)); // Create a mutable copy

        List<EdgeLEC> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet();

        for (VertexLEC vertex : vertices) {
            disjointSet.makeSet(vertex);
        }

        mutableEdges.sort(Comparator.comparingDouble(EdgeLEC::getWeight));

        for (EdgeLEC edge : mutableEdges) {
            VertexLEC startVertex = edge.getStart();
            VertexLEC endVertex = edge.getEnd();

            if (disjointSet.find(startVertex) != disjointSet.find(endVertex)) {
                minimumSpanningTree.add(edge);
                disjointSet.union(startVertex, endVertex);
            }
        }

        return minimumSpanningTree;
    }
}

