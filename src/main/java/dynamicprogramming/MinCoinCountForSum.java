package dynamicprogramming;


public class MinCoinCountForSum {
    public static double solveDynamic(int targetSum, int[] coinValues) {
        double[] minCount = new double[targetSum + 1];
        minCount[0] = 0;
        for (int i = 1; i < targetSum + 1; i++) {
            minCount[i] = Double.POSITIVE_INFINITY;
        }
        for (int currentSum = 1; currentSum < targetSum + 1; currentSum++) {  // Consider each value up to target
            for (int coinValue : coinValues) { // Consider each coin in turn
                if (coinValue <= currentSum) { // This coin is possibly a part of the solution
                    if (minCount[currentSum - coinValue] + 1 < minCount[currentSum])
                        minCount[currentSum] = minCount[currentSum - coinValue] + 1;
                }
            }
        }
        return minCount[targetSum];
    }

    private static double solveRecursive(int targetSum, int [] coinValues, double [] minCount) {
        if (targetSum == 0) { return 0; }

        for (int coinValue : coinValues) {
            if (coinValue <= targetSum) {
                Double intermediate = solveRecursive(targetSum - coinValue, coinValues, minCount);
                if (intermediate + 1 < minCount[targetSum]) {
                    minCount[targetSum] = intermediate + 1;
                }
            }
        }
        return minCount[targetSum];
    }

    public static double solveRecursive(int targetSum, int[] coinValues) {
        double[] minCount = new double[targetSum + 1];
        minCount[0] = 0;
        for (int i = 1; i < targetSum + 1; i++) {
            minCount[i] = Double.POSITIVE_INFINITY;
        }
        minCount[0] = 0;
        return solveRecursive(targetSum, coinValues, minCount);
    }
}


