package examples.lambdaslynda.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateImpl {

    public class Classical implements Predicate<String>{
        @Override
        public boolean test(String input) {
            return input.length() < 10? true: false;
        }
    }

    public boolean lambda (String input) {
        Predicate<String> lengthPredicate = (s) -> s.length() < 10;
        return lengthPredicate.test(input);

    }
    public static void main(String[] args) {
        PredicateImpl predicateLambda = new PredicateImpl();
        PredicateImpl.Classical classical = predicateLambda.new Classical();

        System.out.println("Lambda version: " + predicateLambda.lambda("Sameer") + " - Sameer is less than 10");
        System.out.println("Classical version: " + classical.test("Sameer") + " - Sameer is less than 10");
        System.out.println("Lambda version: " + predicateLambda.lambda("Anachronistically") + " - Anachronistically is less than 10");
        System.out.println("Classical version: " + classical.test("Anachronistically") + " - Anachronistically is less than 10");

    }
}
