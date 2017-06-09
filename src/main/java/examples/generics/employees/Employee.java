package examples.generics.employees;

import lombok.Data;

@Data
public class Employee<E> {
    private E employee;
}
