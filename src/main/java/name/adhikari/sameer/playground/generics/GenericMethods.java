package name.adhikari.sameer.playground.generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethods {

    public static <T> int countOccurences(Collection<T> collection, T itemToCount) {
        int count = 0;
        if (itemToCount == null) {
            for (T item : collection) {
                count++;
            }
        } else {
            for (T item : collection) {
                if (item == itemToCount) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integerArrayList.add(1);
        }
        System.out.println("The number of '1's = " + String.valueOf(GenericMethods.countOccurences(integerArrayList, 1)));

        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            characterArrayList.add('a');
        }
        System.out.println("The number of 'a's = " + String.valueOf(GenericMethods.countOccurences(characterArrayList, 'a')));
    }

}
