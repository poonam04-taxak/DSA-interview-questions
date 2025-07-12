public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int col = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int indx) {
        if (indx == word.length()) {
            return true; // all chars matched
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(indx)) {
            return false;
        }
        
        char temp = board[row][col]; // store to restore later
        board[row][col] = '#';       // mark visited

        boolean found = dfs(board, row + 1, col, word, indx + 1) ||
                        dfs(board, row - 1, col, word, indx + 1) ||
                        dfs(board, row, col + 1, word, indx + 1) ||
                        dfs(board, row, col - 1, word, indx + 1);

        board[row][col] = temp; // backtrack

        return found;
    }
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(ws.exist(board, word)); // Output: true
    }

}
/*class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(mat, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] mat, String word, int row, int col, int idx) {
        if (idx == word.length()) {
            return true; // all characters matched
        }
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[0].length || mat[row][col] != word.charAt(idx)) {
            return false; // out of bounds or char mismatch
        }

        char temp = mat[row][col];
        mat[row][col] = '#'; // mark as visited

        // explore all 4 directions
        boolean found = dfs(mat, word, row + 1, col, idx + 1) ||
                        dfs(mat, word, row - 1, col, idx + 1) ||
                        dfs(mat, word, row, col + 1, idx + 1) ||
                        dfs(mat, word, row, col - 1, idx + 1);

        mat[row][col] = temp; // backtrack (restore)

        return found;
    }
}
 */