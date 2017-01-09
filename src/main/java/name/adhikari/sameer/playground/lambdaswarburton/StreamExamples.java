package name.adhikari.sameer.playground.lambdaswarburton;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamExamples {
    public static void main(String[] args) {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());
        assert(Arrays.asList("a", "b", "c").equals(collected));
    }
}
