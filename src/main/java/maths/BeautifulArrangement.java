package maths;

import java.util.Arrays;

/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these
 * N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 * 1. The number at the ith position is divisible by i.
 * 2. i is divisible by the number at the ith position.
 * Now given N, how many beautiful arrangements can you construct?
 */

public class BeautifulArrangement {
    private int count = 0;
    int N = 0;

    private boolean isBeautifulArrangement(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % (i + 1) == 0 || (i + 1) % array[i] == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    private void generateArrangement(String prefix, String suffix) {
        if (prefix.length() == this.N) {
            int[] array = new int[N];
            for (int i = 0; i < this.N; i++) {
                array[i] = prefix.charAt(i) - '0';
            }
            if (isBeautifulArrangement(array)) {
                count++;
            }
            return;
        }

        for (int i = 0; i < suffix.length(); i++) {
            generateArrangement(prefix + suffix.charAt(i),
                    suffix.substring(0, i) + suffix.substring(i + 1)
            );
        }
        return;
    }


    public int countArrangement(int N) {
        this.N = N;
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(i);
        }
        generateArrangement("", sb.toString());
        return this.count;
    }
}
