/*
 * SuDoKu solver
 */
package sudoku;

/**
 *
 * @author MANDEEP VRATESH
 */
public class SuDoKu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int board[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                         {5, 2, 0, 0, 0, 0, 0, 0, 0},
                         {0, 8, 7, 0, 0, 0, 0, 3, 1},
                         {0, 0, 3, 0, 1, 0, 0, 8, 0},
                         {9, 0, 0, 8, 6, 3, 0, 0, 5},
                         {0, 5, 0, 0, 9, 0, 6, 0, 0},
                         {1, 3, 0, 0, 0, 0, 2, 5, 0},
                         {0, 0, 0, 0, 0, 0, 0, 7, 4},
                         {0, 0, 5, 2, 0, 6, 3, 0, 0}
                        };
        /*int board[][] = {{0,2,0,0},
                         {1,0,0,4},
                         {2,0,0,3},
                         {0,0,4,0}};
        /*int board[][] = {{0,2,4,1},
                         {4,1,3,2},
                         {1,4,2,3},
                         {2,3,1,4}};*/
        int present_col = 0, present_row = 0, size = board[0].length;
        play(board,present_row,present_col,size);
        show(board,size);
        //System.out.print(isSafe(board, 3, 0, 4, 2));
    }
/**
 * this method is the main backtracking method. It places the queens on the board.
 * @param board a 2-D integer array which represents the chess board
 * @param present_col the column to start with
 * @param size size of the board
 */
    private static boolean play(int[][] board,int present_row, int present_col, int size) {
        
//        System.out.println(present_row+","+present_col);
        //if reached out of board return false
        if(present_row>=size){
//            System.out.println("present row >= size");
            return true;
        }
        if(board[present_row][present_col]==0){
//            System.out.println("went inside");
            for(int i=1; i<=size; i++){
//                System.out.println(i);
                if(isSafe(board, present_row,present_col,size,i)){
                    board[present_row][present_col] = i;
//                    System.out.println(present_row+","+present_col);
//                    show(board,size);
                    if(present_col==size-1){
//                        System.out.println(present_row+","+present_col);
//                        System.out.println("reached here1");
                        if(play(board,present_row+1,0,size)){
//                            System.out.println("reached here2");
                            return true;
                        }else{
//                            System.out.println("returning back1");
                        }
                    }else{
//                        System.out.println("reached here3");
//                        System.out.println(present_row+","+present_col);
                        if(play(board,present_row,present_col+1,size)){
//                            System.out.println("reached here4");
                            return true;
                        }else{
//                            System.out.println("returning back2");
                        }
                    }
//                    System.out.println("reached here5");
                    board[present_row][present_col] = 0;
//                    System.out.println(present_row+","+present_col);
//                    show(board,size);
                }
            }
        }else{
            if(present_col==size-1){
//                System.out.println(present_row+","+present_col);
                if(play(board,present_row+1,0,size)){
                    return true;
                }
            }else{
//                System.out.println(present_row+","+present_col);
                if(play(board,present_row,present_col+1,size)){
                    return true;
                }
            }
        }
//        System.out.println(present_row+","+present_col+"reached herexxxxx");
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
    private static boolean isSafe(int[][] board, int row, int col, int size, int number){
        //check if the number is present in the same row
        for(int i=0; i<size; i++){
            if(board[row][i]==number){
//                System.out.print("row");
                return false;
            }
        }
        
        //check if the number is present in the same column
        for(int i=0; i<size; i++){
            if(board[i][col]==number){
//                System.out.print("col");
                return false;
            }
        }
        
        //check if the number is in the same box
        int box_start_row = row-(row%(int)Math.sqrt(size));
        int box_start_col = col-(col%(int)Math.sqrt(size));
        
//        System.out.println("box_start_row="+box_start_row+" box_start_col="+box_start_col);
        
        for(int i=box_start_row,j=box_start_col; i<box_start_row+(int)Math.sqrt(size)&&j<box_start_col+(int)Math.sqrt(size); i++,j++){
//            System.out.println("shit"+board[i][j]+" "+number+" "+i+" "+j);
            if(board[i][j]==number){
//                System.out.println("shit"+board[i][j]+" "+number+" "+i+" "+j);
                return false;
            }
        }
        
        return true;
    }

    private static void show(int[][] board, int size) {
        //print the board
        for(int i=0; i<size; i++){
            for(int j=0; j<size;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("=====================");
    }

}
