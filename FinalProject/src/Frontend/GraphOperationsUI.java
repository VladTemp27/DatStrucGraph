package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphOperationsUI {
    private JFrame frame;
    private JPanel mainPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                PathOperationsUI window = new PathOperationsUI();
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
        JOptionPane.showMessageDialog(frame, "Directed Graph Operation");
    }

    private void performUndirectedGraphOperation(ActionEvent e) {
        // Implement logic for Undirected Graph operation
        JOptionPane.showMessageDialog(frame, "Undirected Graph Operation");
    }

    private void performDepthFirstTraversal(ActionEvent e) {
        // Implement logic for Depth-First Traversal operation
        JOptionPane.showMessageDialog(frame, "Depth-First Traversal Operation");
    }

    private void performBreadthFirstTraversal(ActionEvent e) {
        // Implement logic for Breadth-First Traversal operation
        JOptionPane.showMessageDialog(frame, "Breadth-First Traversal Operation");
    }

    private void performDijkstraAlgorithm(ActionEvent e) {
        // Implement logic for Dijkstra's Algorithm operation
        JOptionPane.showMessageDialog(frame, "Dijkstra's Algorithm Operation");
    }

    private void performPrimsAlgorithm(ActionEvent e) {
        // Implement logic for Prim's Algorithm operation
        JOptionPane.showMessageDialog(frame, "Prim's Algorithm Operation");
    }

    private void performKruskalsAlgorithm(ActionEvent e) {
        // Implement logic for Kruskal's Algorithm operation
        JOptionPane.showMessageDialog(frame, "Kruskal's Algorithm Operation");
    }

    private void performGraphColoring(ActionEvent e) {
        // Implement logic for Graph Coloring operation
        JOptionPane.showMessageDialog(frame, "Graph Coloring Operation");
    }
}
