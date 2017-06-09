package examples.generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethods {

    public static <T> int countOccurences(Collection<T> collection, T itemToCount) {
        if (itemToCount == null) {
            return collection.size();
        }
        int count = 0;
        for (T item : collection) {
            if (item == itemToCount) {
                count++;
            }
        }
        return count;
    }

    public static <T extends Comparable> int countGreaterThan(Collection<T> collection, T threshold) {
        int count = 0;
        for (T item : collection) {
            if (item.compareTo(threshold) > 0) { // Cannot use the > operator with generics
                count++;
            }
        }
        return count;
    }


    public static <T> void print(Collection<T> collection) {
        for (T item : collection) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            integerArrayList.add(i);
        }
        GenericMethods.print(integerArrayList);
        System.out.println("The number of '1's = " + String.valueOf(GenericMethods.countOccurences(integerArrayList, 1)));
        System.out.println("The number of numbers > 5 = " + String.valueOf(GenericMethods.countGreaterThan(integerArrayList, 5)));


        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char i = 'a'; i <= 'j'; i++) {
            characterArrayList.add(i);
        }
        GenericMethods.print(characterArrayList);
        System.out.println("The number of 'a's = " + String.valueOf(GenericMethods.countOccurences(characterArrayList, 'a')));
        System.out.println("The number of characters > 'e' = " + String.valueOf(GenericMethods.countGreaterThan(characterArrayList, 'e')));
    }

}
