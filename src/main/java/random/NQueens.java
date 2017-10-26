package random;

import java.util.LinkedList;
import java.util.List;

public class NQueens {

    private List<String> convert(boolean [][] board) {
        List<String> result = new LinkedList<>();
        for(int i = 0; i < board.length; i++) {
            StringBuffer buffer = new StringBuffer();
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j]) buffer.append('Q');
                else buffer.append('.');
            }
            result.add(buffer.toString());
        }
        return result;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        for (int j = 0; j < col; j++) { // on this row to the left
            if (board[row][j]) return false;
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) { // left top diagonal
            if (board[i][j]) return false;
        }
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) { // left bottom diagonal
            if (board[i][j]) return false;
        }
        return true;
    }

    private void solveNQueens(boolean [][] board, int col, List<List<String>> result) {
        if(col == board.length) { // we have already place [0...N-1]
           result.add(convert(board));
           return;
        }
        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = true; // place the queen
                solveNQueens(board, col + 1, result);
                board[i][col] = false; // backtrack to explore other alternatives
            }
        }
        return;
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        boolean [][] board = new boolean[n][n];
        solveNQueens(board, 0, result);
        return result;
    }


}
