package Backend;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private final Map<Vertex, Vertex> parent;
    private final Map<Vertex, Integer> rank;

    public DisjointSet() {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
    }

    public void makeSet(Vertex vertex) {
        parent.put(vertex, vertex);
        rank.put(vertex, 0);
    }

    public Vertex find(Vertex vertex) {
        if (vertex != parent.get(vertex)) {
            parent.put(vertex, find(parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    public void union(Vertex x, Vertex y) {
        Vertex rootX = find(x);
        Vertex rootY = find(y);

        if (rootX != rootY) {
            if (rank.get(rootX) < rank.get(rootY)) {
                parent.put(rootX, rootY);
            } else if (rank.get(rootX) > rank.get(rootY)) {
                parent.put(rootY, rootX);
            } else {
                parent.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }
        }
    }
}
