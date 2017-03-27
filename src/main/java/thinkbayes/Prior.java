package thinkbayes;

import java.util.function.Function;

public enum Prior implements Function<Float, Float>{
    UNIFORM((Float x) -> 1F),
    POWER_LAW((Float x) -> 1F / x.floatValue()),
    TRIANGLE_101 ((Float x) -> { if (x >= 0F && x < 51F) return x; else return 100F - x;}); // 0 <= x <= 100

    private final Function<Float, Float> function;

    Prior(Function<Float, Float> function) {
        this.function = function;
    }

    @Override
    public Float apply(Float input) {
        return function.apply(input);
    }
}
