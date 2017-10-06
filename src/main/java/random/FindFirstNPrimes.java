package random;

import java.util.ArrayList;

public class FindFirstNPrimes {
    // This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

// implement method that prints the first 100 prime numbers
// A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.

    private static ArrayList<Integer> foundPrimes = new ArrayList<>();

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) {
            foundPrimes.add(num);
            return true;
        }
        if (num % 2 == 0) return false;
        for (int k = 0; k < foundPrimes.size(); k = k + 1) {
            if (num % foundPrimes.get(k) == 0) return false;
        }
        foundPrimes.add(num);
        return true;
    }

    public static void findNPrimes(int n) {
        if (n == 1) {
            System.out.println(2);
            return;
        }

        System.out.println(2);
        int k = 1;
        int target = 3;
        while (k < n) {
            if (isPrime(target)) {
                System.out.println(target);
                k++;
            }
            target += 2;
        }
    }

    public static void main(String[] args) {
        FindFirstNPrimes.findNPrimes(7);
    }


}
