package maths;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * Given a randInt(), a number N for the range to generate random numbers, and a blacklist
 * to exclude from the range, create a function to return randdom number uniformly over
 * the range but excluding the numbers from the blacklist.
 */

public class RandomGeneratorBlacklist {
    private Map<Integer, Integer> translate = new HashMap<>();

    public RandomGeneratorBlacklist(int N, List<Integer> blacklist) {
        int k = blacklist.size();
        Collections.sort(blacklist);
        int j = 1, target;
        for (Integer i : blacklist) {
            if (i < N - k + 1) {
                target = N - k + j;
                while (blacklist.contains(target)) {
                    target++;
                    j++;
                }
                translate.put(i, target);
                j++;

            } else {
                break;
            }
        }
    }

}
