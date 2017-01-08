package name.adhikari.sameer.playground.lambdaslynda.CanonicalExamples;

import java.math.BigInteger;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

public class MethodReferences {
    public static void main(String[] args) {
        // Use a static method as a lambda
        IntFunction<String> intToStrFn = Integer::toString;
        System.out.println("The length of 1024 as string = " + intToStrFn.apply(1024).length());

        // Use a constructor as a lambda
        Function<String, BigInteger> strToBigIntFn = BigInteger::new;
        System.out.println("String \"987654321\" as BigInteger = " + strToBigIntFn.apply("987654321"));

        // Use an instance method as a lambda
        UnaryOperator<String> createGreeting = "Hello! "::concat;
        System.out.println(createGreeting.apply("Sameer"));
    }
}
