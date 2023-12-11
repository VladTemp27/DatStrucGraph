package Frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PathOperationsUI {
    public JFrame frame;

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
        JOptionPane.showMessageDialog(frame, "Load File Panel");
    }

    private void performDepthFirstTraversal() {
        // Implement logic for Depth First Traversal
        JOptionPane.showMessageDialog(frame, "Perform Depth First Traversal");
    }

    private void performBreadthFirstTraversal() {
        // Implement logic for Breadth First Traversal
        JOptionPane.showMessageDialog(frame, "Perform Breadth First Traversal");
    }

    private void showShortestPath() {
        // Implement logic for showing the shortest path
        JOptionPane.showMessageDialog(frame, "Show Shortest Path");
    }
}
