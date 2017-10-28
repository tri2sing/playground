package dynamicprogramming;

import java.util.Arrays;

public class SubArrayArithmeticProgressions {

    private void print2DimArray(boolean [][] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
    }

    public int numberOfArithmeticSlices(int[] A) {
        int N = A.length;
        if (N < 3) return 0;

        boolean[][] isProgression = new boolean[N][N];
        // initialize all length 3 sequences
        for (int i = 0; i < N - 2; i++) {
            if ((A[i + 2] - A[i + 1]) == (A[i + 1] - A[i]))
                isProgression[i][i + 2] = true;
        }
        //print2DimArray(isProgression);
        for (int l = 4; l <= N; l++) {
            for (int i = 0; i < N - l + 1; i++) {
                if (A[i + l - 1] - A[i + l - 2] == A[i + l - 2] - A[i + l - 3] && isProgression[i][i + l - 2])
                    isProgression[i][i + l - 1] = true;
            }
        }
        //print2DimArray(isProgression);
        int ans = 0;
        for (int l = 3; l <= N; l++) {
            for (int i = 0; i < N - l + 1; i++) {
                if (isProgression[i][i + l - 1]) ans++;
            }
        }
        return ans;
    }


}
