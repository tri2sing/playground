package graphs;

public class MatrixLongestIncreasingPath {
    private static int [][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
    private int [][] cache;
    private int M, N;

    private int dfs(int [][] matrix, int i, int j) {
        // check whether we are within the bound of the array
        if(cache[i][j] != 0) return cache[i][j]; // if we have memoized the value

        int max = 1;
        for(int [] direction: directions) {
            int x = i + direction[0], y = j + direction[1];
            if(x < 0 || y < 0 || x >= M || y >= N || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y);
            max = Math.max(max, len);
        }
        cache[i][j] = max; // memoize
        return cache[i][j];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        M = matrix.length;
        if(M == 0) return 0;
        N = matrix[0].length;
        cache = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                int current = dfs(matrix, i, j);
                result = Math.max(current, result);
            }
        }
        return result;
    }
}
