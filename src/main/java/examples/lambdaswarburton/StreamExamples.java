package examples.lambdaswarburton;

import lombok.Getter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;


public class StreamExamples {

    @Getter
    public class AlpabetichNumeric {
        private String alpha;
        private int num;

        public AlpabetichNumeric(String alpha, int num) {
            this.alpha = alpha;
            this.num = num;
        }
    }

    public static void main(String[] args) {

        // Example of collecting results of a stream.
        List<String> collected = Stream.of("a", "b", "c")
                .collect(toList());
        assert(asList("a", "b", "c").equals(collected));

        // Map operation on a stream.
        List<String> uppers = Stream.of("a", "b", "c")
                                .map(string -> string.toUpperCase())
                                .collect(toList());
        assert(asList("A", "B", "C").equals(uppers));

        // Filter operation on a stream.
        List<String> beginsWithNumber = Stream.of("a", "1abc", "abc1")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(toList());
        assert (asList("1abc").equals(beginsWithNumber));

        List<Integer> combined = Stream.of(asList(2, 1), asList(4, 3))
                .flatMap(individual -> individual.stream())
                .collect(toList());
        assert (asList(2, 1, 4, 3).equals(combined));

        //Count operation on a stream
        long count = Stream.of("a", "b", "c")
                .count();
        assert(count == 3);

        StreamExamples examples = new StreamExamples();
        List<StreamExamples.AlpabetichNumeric> alphanums = asList(
                examples.new AlpabetichNumeric("a", 80),
                examples.new AlpabetichNumeric("ab", 90),
                examples.new AlpabetichNumeric("abc", 100)
        );

        StreamExamples.AlpabetichNumeric maxNum = alphanums.stream()
                .max(Comparator.comparing(value -> value.getNum()))
                .get();

        System.out.println(maxNum.getAlpha() + ", " + maxNum.getNum());
        assert (maxNum.getNum() == 100);
        assert (maxNum.equals(alphanums.get(2)));

        StreamExamples.AlpabetichNumeric minStr = alphanums.stream()
                .min(Comparator.comparing(value -> value.getAlpha().length()))
                .get();
        System.out.println(minStr.getAlpha() + ", " + minStr.getNum());
        assert (minStr.getAlpha().length() == 3);
        assert (minStr.equals(alphanums.get(0)));


        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (acc, elem) -> acc + elem);
        assert (sum == 15);
    }
}
