package Backend;

import java.util.*;

public class GraphColoring {
    public static Map<VertexLEC, Integer> colorGraph(List<VertexLEC> vertices) {
        Map<VertexLEC, Integer> vertexColors = new HashMap<>();
        Set<Integer> usedColors = new HashSet<>();

        for (VertexLEC vertex : vertices) {
            int availableColor = getAvailableColor(usedColors);
            vertexColors.put(vertex, availableColor);
            usedColors.add(availableColor);
        }

        return vertexColors;
    }

    private static int getAvailableColor(Set<Integer> usedColors) {
        int color = 0;
        while (usedColors.contains(color)) {
            color++;
        }
        return color;
    }
}
