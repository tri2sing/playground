package thinkbayes;

import java.util.function.Function;

public enum Prior implements Function<Float, Float>{
    UNIFORM((Float x) -> 1F),
    POWER_LAW((Float x) -> 1F / x.floatValue());

    private final Function<Float, Float> function;

    private Prior(Function<Float, Float> function) {
        this.function = function;
    }

    @Override
    public Float apply(Float input) {
        return function.apply(input);
    }
}
