package graphs;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    private double findPath(HashMap<String, HashMap<String, Double>> graph, String src, String dest) {
        LinkedList<Map.Entry<String, Double>> queue = new LinkedList<>();
        Map.Entry<String, Double> item = new AbstractMap.SimpleEntry<>(src, 1.0);
        Set<String> visited = new HashSet<>();

        queue.add(item);
        while (queue.size() > 0) {
            item = queue.remove();
            visited.add(item.getKey());
            HashMap<String, Double> neighbors = graph.get(item.getKey());
            if (neighbors == null) return -1.0;
            if (item.getKey().equals(dest)) return item.getValue();
            for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
                if (!visited.contains(neighbor.getKey()))
                    queue.add(new AbstractMap.SimpleEntry<>(neighbor.getKey(), neighbor.getValue() * item.getValue()));
            }
        }
        return -1.0;
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // Create the graph in forward and reverse directions.
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            HashMap<String, Double> forward = graph.get(equations[i][0]);
            if (forward == null) {
                forward = new HashMap<>();
                graph.put(equations[i][0], forward);
            }
            forward.put(equations[i][1], values[i]);
            HashMap<String, Double> reverse = graph.get(equations[i][1]);
            if (reverse == null) {
                reverse = new HashMap<>();
                graph.put(equations[i][1], reverse);
            }
            reverse.put(equations[i][0], 1 / values[i]);
        }
        // Work through queries
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = findPath(graph, queries[i][0], queries[i][1]);
        }
        return result;
    }
}
