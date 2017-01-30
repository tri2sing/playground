package examples.generics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by samadhik on 12/10/16.
 */

@Data
@AllArgsConstructor
public class GenericTupleBounded<K extends Number, V extends List> {
    private K key;
    private V val;

    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        list1.add("one");
        GenericTupleBounded<Integer, LinkedList> tuple1 =
                new GenericTupleBounded<>(1, list1);
        list1.add("two");

        list2.add(1);
        GenericTupleBounded<Integer, ArrayList> tuple2 =
                new GenericTupleBounded<>(2, list2);
        list2.add(2);

        System.out.println("tuple1 = " + tuple1);
        System.out.println("tuple2 = " + tuple2);
    }
}
