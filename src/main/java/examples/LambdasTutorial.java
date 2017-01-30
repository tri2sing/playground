package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * Created by samadhik on 11/29/16.
 */
public class LambdasTutorial {

    public static class LengthComparator implements Comparator<String> {
        public int compare(String first, String second) {
            return Integer.compare(first.length(), second.length());
        }
    }

    public static void useLambdaForComparator() {
        String[] strings = {"am", "crazy", "for", "some", "healthy", "nutrition"};
        System.out.println("original array: " + Arrays.toString(strings));

        Arrays.sort(strings, new LengthComparator());
        System.out.println("sort custom comparator class: " + Arrays.toString(strings));

        Arrays.sort(strings);
        System.out.println("sort using default java sort: " + Arrays.toString(strings));

        Arrays.sort(strings,
                (String first, String second) -> {
                    if (first.length() < second.length()) return -1;
                    else if (first.length() > second.length()) return 1;
                    else return 0;
                }
        );
        System.out.println("sort on length using lambda1: " + Arrays.toString(strings));

        Arrays.sort(strings);
        System.out.println("sort using default java sort: " + Arrays.toString(strings));

        Comparator<String> comp = (first, second) -> {
            return Integer.compare(first.length(), second.length());
        };

        Arrays.sort(strings, comp);
        System.out.println("sort on length using lambda2: " + Arrays.toString(strings));

        Arrays.sort(strings);
        System.out.println("sort using default java sort: " + Arrays.toString(strings));

        Arrays.sort(strings,
                (first, second) -> {
                    return Integer.compare(first.length(), second.length());
                }
        );
        System.out.println("sort on length using lambda3: " + Arrays.toString(strings));
    }

    public static <T> Collection<T> filter(Collection<T> items, Predicate<T> clause) {
        Collection<T> result = new ArrayList<T>();
        for (T item : items) {
            if (clause.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static void useLambdaForPredicate() {
        Collection<Integer> integers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        Collection<Integer> evens = filter(integers, x -> x % 2 == 0);
        Collection<Integer> odds = filter(integers, x -> x % 2 == 1);
        System.out.println("integers = " + Arrays.toString(integers.toArray()));
        System.out.println("evens = " + Arrays.toString(evens.toArray()));
        System.out.println("odds = " + Arrays.toString(odds.toArray()));
    }


    public static void main(String[] args) {
        //useLambdaForComparator();
        useLambdaForPredicate();
    }
}
