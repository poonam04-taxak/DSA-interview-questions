public class SudokoSolver {
     public static boolean solveSudoku(char[][]board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char num='1';num<='9';num++){
                        if(isSafe(board,row,col,num)){
                            board[row][col]=num;
                            if(solveSudoku(board)){
                                return true;
                            }
                            else{
                                board[row][col]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
     }
     public static boolean isSafe(char[][]board,int row,int col,char num){
        for(int i=0;i<9;i++){
            if(board[row][i]==num)return false;
            if(board[i][col]==num)return false;

            int rowBox=3*(row/3)+i/3;
            int colBox=3*(col/3)+i%3;
            if(board[rowBox][colBox]==num)return false;
        }
        return true;
     }
     public static void printBoard(char[][]board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
     }
    public static void main(String[] args) {
         char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        if (solveSudoku(board)) {
            System.out.println("Sudoku Solved:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
