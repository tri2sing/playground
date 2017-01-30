package examples.lambdaswarburton;

import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {
        Optional<String> aStr = Optional.of("a");
        assert (args.equals(aStr.get()));
        assert (aStr.isPresent());

        Optional empty1 = Optional.empty();
        Optional empty2 = Optional.ofNullable(null);
        assert (!empty1.isPresent());
        assert ("b".equals(empty1.orElse("b")));
        assert ("c".equals(empty2.orElseGet(() -> "c")));
    }
}
