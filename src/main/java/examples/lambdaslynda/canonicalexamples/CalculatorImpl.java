package examples.lambdaslynda.canonicalexamples;

public class CalculatorImpl {
    public static void main(String[] args) {
        Calculator<Integer> add = (a, b) -> a + b;
        Calculator<Float> sub = (a, b) -> a - b;
        Calculator<Long> div = (a, b) -> (b != 0? a/b : 0);
        Calculator<Double> mul = (a, b) -> a * b;

        System.out.println(add.calculate(3, 4));
        System.out.println(sub.calculate(10F, 17F));
        System.out.println(div.calculate(50L, 10L));
        System.out.println(mul.calculate(4d, 5d));
    }
}
