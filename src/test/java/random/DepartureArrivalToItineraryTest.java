package random;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DepartureArrivalToItineraryTest {
    DepartureArrivalToItinerary daToI;
    @Before
    public void setUp() {
        daToI = new DepartureArrivalToItinerary();
    }

    @Test
    public void findItinerary1() throws Exception {
        String [][] tickets = new String [][] {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        List<String> result = daToI.findItinerary(tickets);
        List<String> expected = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void findItinerary2() throws Exception {
        String [][] tickets = new String [][] {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        List<String> result = daToI.findItinerary(tickets);
        List<String> expected = Arrays.asList("JFK","NRT","JFK","KUL");
        assertThat(result).isEqualTo(expected);
    }

}
