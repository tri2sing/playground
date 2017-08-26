package random;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectionsMisc {
    public static void main(String[] args) {
        Map<Integer, String> input = new HashMap<>();
        input.put(1, "one");
        input.put(2, "two");
        input.put(3, "three");
        input.put(4, "four");

        Map<String, Integer> output = input.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> e.getValue(),
                        e -> e.getValue().length()
                ));
        System.out.println(input);
        System.out.println(output);
    }
}
