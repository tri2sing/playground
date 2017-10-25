package graphs;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        WeightedUnionFind uf = new WeightedUnionFind(N);
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count();
    }
}
