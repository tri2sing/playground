package examples.generics.employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor @Getter @ToString
public class Engineer {
    private String name;
    private String expertise;
}
