package Backend;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private final Map<VertexLEC, VertexLEC> parent;
    private final Map<VertexLEC, Integer> rank;

    public DisjointSet() {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
    }

    public void makeSet(VertexLEC vertex) {
        parent.put(vertex, vertex);
        rank.put(vertex, 0);
    }

    public VertexLEC find(VertexLEC vertex) {
        if (vertex != parent.get(vertex)) {
            parent.put(vertex, find(parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    public void union(VertexLEC x, VertexLEC y) {
        VertexLEC rootX = find(x);
        VertexLEC rootY = find(y);

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
