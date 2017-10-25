package graphs;

public class WeightedUnionFind {
    private int[] parent; // parent[i] is parent of i
    private int[] size; // size[i] is the size of the tree under i including i
    private int count; // number of connected components

    public WeightedUnionFind(int N) {
        count = N;
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
        for (int i = 0; i < N; i++) size[i] = 1;
    }

    private int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]]; // compressing the tree b moving i up.
            i = parent[i];
        }
        return i;
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }

    public void union(int i, int j) {
        int rooti = find(i);
        int rootj = find(j);
        if (rooti == rootj) return;
        if (size[i] < size[j]) {
            parent[rooti] = rootj;
            size[rootj] += size[rooti];
        } else {
            parent[rootj] = rooti;
            size[rooti] += size[rootj];
        }
        count--; // each union reduces the group count
    }

    public int count() {
        return count;
    }


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
