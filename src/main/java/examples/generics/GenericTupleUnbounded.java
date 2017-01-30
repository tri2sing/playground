package examples.generics;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by samadhik on 12/10/16.
 */

@Data
@AllArgsConstructor
public class GenericTupleUnbounded<K, V> {
    private K key;
    private V val;

    public static void main(String[] args) {
        GenericTupleUnbounded<Integer, String> integerStringTuple = new GenericTupleUnbounded<>(1, "one");
        System.out.println("integerStringTuple = " + integerStringTuple);
        GenericTupleUnbounded<String, Integer> stringIntegerTuple = new GenericTupleUnbounded<>("two", 2);
        System.out.println("stringIntegerTuple = " + stringIntegerTuple);
    }
}
