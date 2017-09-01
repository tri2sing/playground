package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class DepartureArrivalToItinerary {
    private HashMap<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    private void findItinerary(String src) {
        PriorityQueue<String> destinations = graph.get(src);
        while (destinations != null && !destinations.isEmpty()) {
            findItinerary(destinations.poll());
        }
        result.addFirst(src);
    }

    public List<String> findItinerary(String[][] tickets) {
        // Build a grah which, for each source, has the destinations in lexical order.
        for (String[] ticket : tickets) {
            PriorityQueue<String> pQ;
            if (graph.containsKey(ticket[0])) {
                pQ = graph.get(ticket[0]);
            } else {
                pQ = new PriorityQueue<>();
                graph.put(ticket[0], pQ);
            }
            pQ.add(ticket[1]);
        }
        findItinerary("JFK");
        return result;
    }

}
