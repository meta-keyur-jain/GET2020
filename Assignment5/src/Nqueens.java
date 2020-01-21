public class Nqueens {

    /**
     * This method is to check the column and diagonal of the queen it specify weather the queen is allowed to place or not.
     * @param board is the integer array.
     * @param row is the integer variable contain the size of row.
     * @param col is the integer variable contain the size of column.
     * @param size is the integer variable contain the size of the array.
     * @return boolean variable to specify weather the queen is allowed to place or not.
     */
    static boolean toPlaceOrNotToPlace(int board[][], int row, int col, int size) {

        int index,index_j;
        
        //check for left column
        for (index = 0; index < col; index++) { 

            if (board[row][index] == 1)
                return false;
        }
        
        //check for left upper diagonal
        for (index = row, index_j = col; index >= 0 && index_j >= 0; index--, index_j--) {

            if (board[index][index_j] == 1)
                return false;
        }
        
        //check for left lower diagonal
        for (index = row, index_j = col; index_j >= 0 && index < size; index++, index_j--) {

            if (board[index][index_j] == 1)
                return false;
        }
        return true;
    }

    /**
     * This method is for finding the arrangements in the row and columns,
     * and this work with assigning the queens column by column.
     * @param board is the integer array.
     * @param col is the integer variable contain the size of column.
     * @param size is the integer variable contain the size of the array.
     * @return boolean variable that queens get the position or not.
     */
    
    static boolean theBoardSolver(int board[][], int col ,int size) {
        
        //for traversing all the columns.
        if (col >= size)
            return true;
        
        //to specify the position of the queen
        for (int index = 0; index < size; index++) {
            
            //assign the position to queen
            if (toPlaceOrNotToPlace(board, index, col,size)) {
                board[index][col] = 1;
                
                //change the column after assigning the position to the queen
                if (theBoardSolver(board, col + 1,size))
                    return true;
                
                //Backtrack
                board[index][col] = 0;
            }
        }
        return false;
    }

    /**
     * This method will take size of array as input and find the arrangements.
     * @param size is the integer variable.
     * @return 2-Dimensional array with arrangements.
     */
    
    public int[][] solve_nq(int size){
        if (size<=3) {
            throw new AssertionError("  Size should be valid!!");
        }

        int[][] board = new int[size][size];

        if (!theBoardSolver(board, 0,size)) {
            System.out.println("Solution not found.");
        } 

        return board; 

    } 
    
}