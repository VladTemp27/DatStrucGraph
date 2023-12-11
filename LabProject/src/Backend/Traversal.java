package Backend;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.*;

public class Traversal {

    private final Graph graph;
    private StringBuilder shortestPathVertices;

    public Traversal(Graph graph) {
        this.graph = graph;
    }

    // Shortest Path
    public String shortestPath(int sourceId, int destinationId) {
        Vertex root = getVertex(sourceId);
        Vertex destination = getVertex(destinationId);

        Map<Vertex, Double> distanceMap = new HashMap<>();
        Map<Vertex, Vertex> previousVertexMap = new HashMap<>();
        Set<Vertex> verticesVisited = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();

        queue.add(root);
        distanceMap.put(root, 0.0);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            verticesVisited.add(currentVertex);

            for (Edge edge : currentVertex.getAdjacencyList()) {
                Vertex endVertex = edge.getEnd();
                if (!verticesVisited.contains(endVertex)) {
                    double newDistance = distanceMap.get(currentVertex) + edge.getWeight();

                    // If the new distance is shorter than the existing distance
                    if (newDistance < distanceMap.getOrDefault(endVertex, Double.MAX_VALUE)) {
                        distanceMap.put(endVertex, newDistance);
                        previousVertexMap.put(endVertex, currentVertex);
                        queue.add(endVertex);
                    }
                }
            }
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double shortestPath = Double.parseDouble(decimalFormat.format(distanceMap.getOrDefault(destination, Double.MAX_VALUE)));

        shortestPathVertices = new StringBuilder();
        if (shortestPath != Double.MAX_VALUE) {
            constructShortestPath(previousVertexMap, destination);
            return shortestPath + "";
        }
        return "There is no path from " + sourceId + " to " + destinationId;
    }

    // Helper method to construct shortest path
    private void constructShortestPath(Map<Vertex, Vertex> previousVertexMap, Vertex destination) {
        Vertex current = destination;

        while (current != null) {
            shortestPathVertices.insert(0, current + " ");
            current = previousVertexMap.get(current);
        }
    }

    // Helper method to get a vertex by ID
    private Vertex getVertex(int id) {
        return graph.getVertexList().stream()
                .filter(vertex -> vertex.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Getter for shortest path vertices
    public String getShortestPathVertices() {
        return shortestPathVertices.toString();
    }

    // BFS Traversal
    public String BFSTraversal(int id) {
        // Initialize variables
        StringBuilder result = new StringBuilder(); // Stores the traversal result
        Vertex vertex = getVertex(id); // Get starting vertex
        Set<Vertex> verticesVisited = new HashSet<>(); // Track visited vertices
        LinkedList<Vertex> queue = new LinkedList<>(); // Queue for BFS traversal

        // Add starting vertex to queue and mark it visited
        queue.add(vertex);
        verticesVisited.add(vertex);

        // Perform BFS traversal while queue is not empty
        while (!queue.isEmpty()) {
            vertex = queue.poll(); // Dequeue and process current vertex
            result.append(vertex).append(" "); // Add vertex to result

            // Explore adjacent vertices
            for (Edge edge : vertex.getAdjacencyList()) { // Get adjacent vertex
                if (!verticesVisited.contains(edge.getEnd())) { // If not visited mark visited
                    verticesVisited.add(edge.getEnd());
                    queue.add(edge.getEnd()); // Add to queue for further exploration
                }
            }
        }
        return result.toString();
    }

    // DFS Traversal
    public String DFSTraversal(int id) {
        // Initialize variables
        StringBuilder result = new StringBuilder(); // Stores the traversal result
        Vertex vertex = getVertex(id); // Get starting vertex
        Set<Vertex> verticesVisited = new HashSet<>(); // Track visited vertices
        Stack<Vertex> stack = new Stack<>(); // Stack for DFS traversal

        // Add starting vertex to stack and mark it visited
        stack.push(vertex);
        verticesVisited.add(vertex);

        // Perform DFS traversal while stack is not empty
        while (!stack.isEmpty()) {
            vertex = stack.pop(); // Pop and process current vertex
            result.append(vertex).append(" "); // Add vertex to result

            // Explore adjacent vertices
            for (Edge edge : vertex.getAdjacencyList()) { // Get adjacent vertex
                if (!verticesVisited.contains(edge.getEnd())) { // If not visited mark visited
                    verticesVisited.add(edge.getEnd());
                    stack.push(edge.getEnd()); // Push to stack for further exploration
                }
            }
        }
        return result.toString();
    } // end of DFSTraversal method
} // end of Traversal class