package random;

import java.util.ArrayList;

public class TypeErasure {
    public static void main(String[] args) {
        System.out.println("Runtime type of ArrayList<Integer> = " + new ArrayList<Integer>().getClass());
        System.out.println("Runtime type of ArrayList<String> = " + new ArrayList<String>().getClass());
    }
}
