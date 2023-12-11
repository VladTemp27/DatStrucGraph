package Frontend;

import Backend.FileProcessor;
import Backend.Graph;
import Backend.Traversal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class PathOperationsUI {
    public JFrame frame;
    Graph currentGraph;
    Traversal traverser;

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

    public PathOperationsUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new GridLayout(0, 1));

        addButton("Load File", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLoadFilePanel();
            }
        }, mainPanel);

        addButton("Perform Depth First Traversal", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performDepthFirstTraversal();
            }
        }, mainPanel);

        addButton("Perform Breadth First Traversal", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performBreadthFirstTraversal();
            }
        }, mainPanel);

        addButton("Show Shortest Path", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showShortestPath();
            }
        }, mainPanel);

        addButton("Exit", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }, mainPanel);
    }

    private void addButton(String label, ActionListener actionListener, JPanel panel) {
        JButton button = new JButton(label);
        button.addActionListener(actionListener);
        panel.add(button);
    }

    private void openLoadFilePanel() {
        // Implement logic for opening the Load File panel
        String fileName = JOptionPane.showInputDialog(frame, "Enter file name");
        FileProcessor fileProcessor = new FileProcessor();
        try {
            currentGraph = fileProcessor.fetchFromFile("LabProject/src/input/" + fileName);
            traverser = new Traversal(currentGraph);
        }catch(FileNotFoundException fNFE){
            JOptionPane.showMessageDialog(frame, "File does not exist");
        }
    }

    private void performDepthFirstTraversal() {
        // Implement logic for Depth First Traversal
        int startVertex = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter start vertex"));
        JOptionPane.showMessageDialog(frame, "Traversal Result: "+traverser.DFSTraversal(startVertex));
    }

    private void performBreadthFirstTraversal() {
        // Implement logic for Breadth First Traversal
        int startVertex = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter start vertex"));
        JOptionPane.showMessageDialog(frame, "Breadth First Traversal: "+traverser.BFSTraversal(startVertex));
    }

    private void showShortestPath() {
        // Implement logic for showing the shortest path
        int startVertex = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter start vertex"));
        int endVertex = Integer.parseInt(JOptionPane.showInputDialog(frame,"Enter end vertex"));
        JOptionPane.showMessageDialog(frame, "Shortest Path: "+traverser.shortestPath(startVertex,endVertex));
    }
}
