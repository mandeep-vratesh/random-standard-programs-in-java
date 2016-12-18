/*
 * A program to solve N-Queen problem
 */
package NQueenProblem;

/**
 *
 * @author MANDEEP VRATESH
 */
public class NQueenProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0},
                         {0,0,0,0,0,0,0,0}
                        };
        int present_column = 0, size = 8;
        play(board,present_column,size);
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
/**
 * this method is the main backtracking method. It places the queens on the board.
 * @param board a 2-D integer array which represents the chess board
 * @param present_column the column to start with
 * @param size size of the board
 */
    private static boolean play(int[][] board, int present_column, int size) {
        if(present_column == size){
            return true;
        }
        
        for(int i=0; i<size; i++){
            if(isSafe(board,i,present_column,size)){
                board[i][present_column] = 1;
                if(play(board,present_column+1,size)){
                    return true;
                }
                board[i][present_column] = 0;
            }
        }
        return false;
    }

/**
 * this method checks if the queen is safe where it has been placed
 * @param board current status of the board
 * @param row row coordinate to be checked
 * @param col column coordinate to be checked
 * @param N size of the board
 * @return true if its safe, false if not.
 */
    private static boolean isSafe(int[][] board, int row, int col, int N){
        //check for another queen in the same row
        for(int i=0; i<col; i++){
            if(board[row][i]==1){
                return false;
            }
        }
        
        //check for another queen in the same column
        for(int i=0; i<row; i++){
            if(board[i][col]==1){
                return false;
            }
        }
        
        //check for the queen in the main diagonal
        for(int i=row-1,j=col-1; i>=0&&j>=0; i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        
        //check for the queen in the anti diagonal
        for(int i=row-1,j=col+1; i>=0&&j<N; i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }
        
        return true;
    }
    
}
