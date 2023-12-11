package Frontend;

import Backend.*;

import static Backend.BreadthFirstTraversal.breadthFirstTraversal;
import static Backend.DepthFirstTraversal.depthFirstTraversal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class GraphOperationsUI {
    private JFrame frame;
    private JPanel mainPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                GraphOperationsUI window = new GraphOperationsUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphOperationsUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new GridLayout(0, 1));

        addButton("Directed Graph", this::performDirectedGraphOperation);
        addButton("Undirected Graph", this::performUndirectedGraphOperation);
        addButton("Depth-First Traversal", this::performDepthFirstTraversal);
        addButton("Breadth-First Traversal", this::performBreadthFirstTraversal);
        addButton("Dijkstra's Algorithm", this::performDijkstraAlgorithm);
        addButton("Prim's Algorithm", this::performPrimsAlgorithm);
        addButton("Kruskal's Algorithm", this::performKruskalsAlgorithm);
        addButton("Graph Coloring", this::performGraphColoring);
    }

    private void addButton(String label, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.addActionListener(actionListener);
        mainPanel.add(button);
    }

    private void performDirectedGraphOperation(ActionEvent e) {
        // Implement logic for Directed Graph operation
        DirectedGraph directedGraph = new DirectedGraph();

        // Adding vertices
        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");

        // Adding edges
        directedGraph.addEdge("A", "B");
        directedGraph.addEdge("B", "C");
        directedGraph.addEdge("C", "A");

        // Performing some operation, e.g., getting neighbors of a vertex
        List<String> neighborsOfA = directedGraph.getNeighbors("A");
        String outputMessage = "Directed Graph Operation\nNeighbors of A: " + neighborsOfA + "\n";
        JOptionPane.showMessageDialog(frame, outputMessage);
    }

    private void performUndirectedGraphOperation(ActionEvent e) {
        // Implement logic for Undirected Graph operation
        UndirectedGraph undirectedGraph = new UndirectedGraph();

        // Adding vertices
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");

        // Adding edges
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("B", "C");
        undirectedGraph.addEdge("C", "A");

        // Performing some operation, e.g., getting neighbors of a vertex
        List<String> neighborsOfA = undirectedGraph.getNeighbors("A");
        String outputMessage = "Undirected Graph Operation\nNeighbors of A: " + neighborsOfA + "\n";
        JOptionPane.showMessageDialog(frame, outputMessage);
    }

    private void performDepthFirstTraversal(ActionEvent e) {
        // Implement logic for Depth-First Traversal operation
        UndirectedGraph undirectedGraph = new UndirectedGraph();

        // Adding vertices
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        undirectedGraph.addVertex("D");

        // Adding edges
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("B", "C");
        undirectedGraph.addEdge("C", "A");
        undirectedGraph.addEdge("C", "D");

        // Performing Depth-First Traversal
        List<String> traversalResult = depthFirstTraversal(undirectedGraph, "A");
        String outputMessage = "Depth-First Traversal Operation\nResult: " + traversalResult + "\n";
        JOptionPane.showMessageDialog(frame, outputMessage);
    }

    private void performBreadthFirstTraversal(ActionEvent e) {
        // Implement logic for Breadth-First Traversal operation
        UndirectedGraph undirectedGraph = new UndirectedGraph();

        // Adding vertices
        undirectedGraph.addVertex("A");
        undirectedGraph.addVertex("B");
        undirectedGraph.addVertex("C");
        undirectedGraph.addVertex("D");

        // Adding edges
        undirectedGraph.addEdge("A", "B");
        undirectedGraph.addEdge("B", "C");
        undirectedGraph.addEdge("C", "A");
        undirectedGraph.addEdge("C", "D");

        // Performing Breadth-First Traversal
        List<String> traversalResult = breadthFirstTraversal(undirectedGraph, "A");
        String outputMessage = "Breadth-First Traversal Operation\nResult: " + traversalResult + "\n";
        JOptionPane.showMessageDialog(frame, outputMessage);
    }

    private void performDijkstraAlgorithm(ActionEvent e) {
        // Implement logic for Dijkstra's Algorithm operation
        UndirectedWeightedGraph weightedGraph = new UndirectedWeightedGraph();

        // Adding vertices
        weightedGraph.addVertex("A");
        weightedGraph.addVertex("B");
        weightedGraph.addVertex("C");
        weightedGraph.addVertex("D");

        // Adding weighted edges
        weightedGraph.addEdge("A", "B", 2);
        weightedGraph.addEdge("B", "C", 1);
        weightedGraph.addEdge("C", "A", 4);
        weightedGraph.addEdge("C", "D", 3);

        // Performing Dijkstra's Algorithm using the DijkstraAlgorithm class
        Map<String, Integer> shortestDistances = DijkstraAlgorithm.dijkstra(weightedGraph, "A");
        String outputMessage = "Dijkstra's Algorithm Operation\nShortest Distances from A: " + shortestDistances + "\n";
        JOptionPane.showMessageDialog(frame, outputMessage);
    }

    private void performPrimsAlgorithm(ActionEvent e) {
        // Implement logic for Prim's Algorithm operation
        UndirectedWeightedGraph weightedGraph = new UndirectedWeightedGraph();

        // Create vertices
        VertexLEC vertexA = new VertexLEC(1);
        VertexLEC vertexB = new VertexLEC(2);
        VertexLEC vertexC = new VertexLEC(3);
        VertexLEC vertexD = new VertexLEC(4);

        // Create edges
        EdgeLEC edgeAB = new EdgeLEC(vertexA, vertexB, 2, 1);
        EdgeLEC edgeBC = new EdgeLEC(vertexB, vertexC, 1, 2);
        EdgeLEC edgeCA = new EdgeLEC(vertexC, vertexA, 4, 3);
        EdgeLEC edgeCD = new EdgeLEC(vertexC, vertexD, 3, 4);

        // Create a list of edges
        List<EdgeLEC> edges = List.of(edgeAB, edgeBC, edgeCA, edgeCD);

        // Create a list of vertices
        List<VertexLEC> vertices = List.of(vertexA, vertexB, vertexC, vertexD);

        // Performing Prim's Algorithm using the PrimAlgorithm class
        List<EdgeLEC> minimumSpanningTree = PrimsAlgorithm.prim(edges, vertices);
        String outputMessage = "Prim's Algorithm Operation\nMinimum Spanning Tree: " + minimumSpanningTree + "\n";
        JOptionPane.showMessageDialog(frame, outputMessage);
    }

    private void performKruskalsAlgorithm(ActionEvent e) {
        // Implement logic for Kruskal's Algorithm operation

        // Create vertices
        VertexLEC vertexA = new VertexLEC(1);
        VertexLEC vertexB = new VertexLEC(2);
        VertexLEC vertexC = new VertexLEC(3);
        VertexLEC vertexD = new VertexLEC(4);

        // Create edges
        EdgeLEC edgeAB = new EdgeLEC(vertexA, vertexB, 2, 1);
        EdgeLEC edgeBC = new EdgeLEC(vertexB, vertexC, 1, 2);
        EdgeLEC edgeCA = new EdgeLEC(vertexC, vertexA, 4, 3);
        EdgeLEC edgeCD = new EdgeLEC(vertexC, vertexD, 3, 4);

        // Create a list of edges
        List<EdgeLEC> edges = List.of(edgeAB, edgeBC, edgeCA, edgeCD);

        // Create a list of vertices
        List<VertexLEC> vertices = List.of(vertexA, vertexB, vertexC, vertexD);

        // Perform Kruskal's Algorithm using the KruskalsAlgorithm class
        List<EdgeLEC> minimumSpanningTree = KruskalsAlgorithm.kruskalsAlgorithm(edges, vertices);
        String outputMessage = "Kruskal's Algorithm Operation\nMinimum Spanning Tree: " + minimumSpanningTree + "\n";
        JOptionPane.showMessageDialog(frame, outputMessage);
    }

    private void performGraphColoring(ActionEvent e) {
        // Implement logic for Graph Coloring operation

        // Create vertices
        VertexLEC vertexA = new VertexLEC(1);
        VertexLEC vertexB = new VertexLEC(2);
        VertexLEC vertexC = new VertexLEC(3);
        VertexLEC vertexD = new VertexLEC(4);

        // Create a list of vertices
        List<VertexLEC> vertices = List.of(vertexA, vertexB, vertexC, vertexD);

        // Perform graph coloring
        Map<VertexLEC, Integer> vertexColors = GraphColoring.colorGraph(vertices);

        // Outputting the results
        StringBuilder outputMessage = new StringBuilder("Graph Coloring Operation\n");

        for (Map.Entry<VertexLEC, Integer> entry : vertexColors.entrySet()) {
            outputMessage.append("Vertex ").append(entry.getKey().getId()).append(" is colored with color ").append(entry.getValue()).append("\n");
        }
        JOptionPane.showMessageDialog(frame, outputMessage.toString());
    }
}
