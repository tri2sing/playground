package name.adhikari.sameer.playground.lambdaslynda.FunctionalInterfaces;

import java.util.function.Function;

public class FunctionImpl {

    public class Classical implements Function<Integer, String> {
        @Override
        public String apply(Integer input) {
            return Integer.toString(input);
        }
    }

    public String useLambda (Integer input) {
        Function<Integer, String> converter = (i) -> Integer.toString(i);
        return converter.apply(input);
    }

    public static void main(String[] args) {
        FunctionImpl functionImpl = new FunctionImpl();
        FunctionImpl.Classical classical = functionImpl.new Classical();

        System.out.println("Classical: Length of 101 = " + classical.apply(101).length());
        System.out.println("Lambda: Length of 101 = " + functionImpl.useLambda(101).length());
    }
}
