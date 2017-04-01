package dynamicprogramming;

public class LongestNonDecreasingSequence {

    public static double solveDynamic(int [] numbers) {
        double [] longestSequence = new double[numbers.length];
        longestSequence[0] = 1;
        for (int i = 1; i < numbers.length; i++) {
            longestSequence[i] = Double.NEGATIVE_INFINITY;
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] >= numbers[i - 1]) {
                if (longestSequence[i - 1] + 1 > longestSequence[i]) {
                    longestSequence[i] = longestSequence[i - 1] + 1;
                }
            } else {
                longestSequence[i] = 1;
            }
        }
        double result = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < numbers.length; i++) {
            if (longestSequence[i] > result) {
                result = longestSequence[i];
            }
        }
        return result;
    }

    private static void solveRecursive (int [] numbers, int start, int end, double[] longestSequence) {
        if (start == end) {
            longestSequence[start] = 1;
            return;
        }
        solveRecursive(numbers, start, end - 1, longestSequence);
        if (numbers[end] >= numbers[end - 1]) {
            if (longestSequence[end - 1] + 1 > longestSequence[end]) {
                longestSequence[end] = longestSequence[end - 1] + 1;
            }
        } else {
            longestSequence[end] = 1;
        }
    }


    public static double solveRecursive(int [] numbers) {
        double [] longestSequence = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            longestSequence[i] = Double.NEGATIVE_INFINITY;
        }
        solveRecursive(numbers, 0, numbers.length - 1, longestSequence);
        double result = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < numbers.length; i++) {
            if (longestSequence[i] > result) {
                result = longestSequence[i];
            }
        }
        return result;
    }
}
