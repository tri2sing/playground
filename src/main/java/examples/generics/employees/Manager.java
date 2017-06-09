package examples.generics.employees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor @Getter @ToString
public class Manager {
    String name;
    String org;
}
