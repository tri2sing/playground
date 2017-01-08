package name.adhikari.sameer.playground.lambdaslynda.CanonicalExamples;

public class CalculatorImpl {
    public static void main(String[] args) {
        Calculator<Integer> add = (a, b) -> a + b;
        Calculator<Float> sub = (a, b) -> a - b;
        Calculator<Long> div = (a, b) -> (b != 0? a/b : 0);
        Calculator<Double> mul = (a, b) -> a * b;

        System.out.println(add.calculate(3, 4));
        System.out.println(sub.calculate(10f, 17f));
        System.out.println(div.calculate(50l, 10l));
        System.out.println(mul.calculate(4d, 5d));
    }
}
