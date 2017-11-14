package heaps;

import java.util.PriorityQueue;

public class KthInSortedMatrix {
    // This if fundamentally the problem of finding kth element in n ordered lists.
    // It has been worded slightly differently using the matrix as the holder.
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            minHeap.add(new HeapNode(i, 0, matrix[i][0]));
        }
        HeapNode node = null;
        for (int j = 0; j < k; j++) {
            node = minHeap.poll();
            if (node.col + 1 < cols)
                minHeap.add(new HeapNode(node.row, node.col + 1, matrix[node.row][node.col + 1]));
        }
        return matrix[node.row][node.col];
    }

    private class HeapNode implements Comparable<HeapNode> {
        int row;
        int col;
        int val;

        public HeapNode(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int compareTo(HeapNode that) {
            return this.val - that.val;
        }
    }
}
