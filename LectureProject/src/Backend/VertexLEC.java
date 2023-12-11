package Backend;

import java.util.ArrayList;
import java.util.List;

public class VertexLEC {

    private final int id;
    private final List<EdgeLEC> adjacencyList = new ArrayList<>();

    public VertexLEC(int id) {
        this.id = id;
    } // end of constructor

    public void addEdge(EdgeLEC edge) {
        if (!adjacencyList.contains(edge)) {
            System.out.println("Added " + edge + " to the adjacency list");
            adjacencyList.add(edge);
        } else {
            System.out.println("This edge is already in the adjacency list for " + edge.getStart().getId());
        }
    } // end of addEdge

    public int getId() {
        return id;
    } // end of getId

    public List<EdgeLEC> getAdjacencyList() {
        return adjacencyList;
    } // end of getAdjacencyList

    @Override
    public String toString() {
        return id + "";
    } // end of toString

    @Override
    public boolean equals(Object object) {
        if (object instanceof VertexLEC otherVertex) {
            return otherVertex.getId() == id;
        }
        return false;
    } // end of equals

    public void printEdges() {
        System.out.print("LIST for (" + id + "): ");
        for (EdgeLEC edge : adjacencyList) {
            System.out.print(edge.getEnd() + " ");
        }
    }

    public void displayEdges() {
        System.out.println("\nList of all edges that node " + id + " has:");
        System.out.println("===========================================");
        for (EdgeLEC edge : adjacencyList) {
            System.out.println("ID of Edge: " + edge.getId() +
                    "\nID of the first node: " + edge.getStart().getId() +
                    "\nID of the second node: " + edge.getEnd().getId());
        }
    }

} // end of VertexLEC class
