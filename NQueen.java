
import java.util.*;

public class NQueen {
    public List<List<String>> nQueen(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, res, n);
        return res;
    }

    private void backtrack(int row, char[][] board, List<List<String>> res, int n) {
        if (row == n) {
            res.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, res, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        // check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
    }

    // ✅ Add a clear main for testing:
    public static void main(String[] args) {
        NQueen obj = new NQueen();
        int n = 4; // test with 4 queens

        List<List<String>> solutions = obj.nQueen(n);

        int count = 1;
        for (List<String> board : solutions) {
            System.out.println("Solution " + count + ":");
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
            count++;
        }
    }
}
