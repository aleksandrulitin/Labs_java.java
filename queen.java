
}public class Queens {
    
    public static final int BOARD_SIZE = 8; 
  
  
    public static final int EMPTY = 0; 
  
  
    public static final int QUEEN = 1; 
  
    private int board[][]; // 
  
    public Queens() {
    
      board = new int[BOARD_SIZE][BOARD_SIZE];
    }      
  
    public void clearBoard() {

  
    public void displayBoard() {
  
  
    public boolean placeQueens(int column) {
 
    // -------------------------------------------------
      if (column >= BOARD_SIZE) {
        return true;  // base case
      } 
      else {
        boolean queenPlaced = false;
        int row = 0;  // number of square in column
  
        while ( !queenPlaced && (row < BOARD_SIZE) )  {
          // if square can be attacked
          if (isUnderAttack(row, column)) {
            ++row;  // consider next square in column
          } // end if
          else { // place queen and consider next column
            setQueen(row, column);
            queenPlaced = placeQueens(column + 1);
            // if no queen is possible in next column,
            if (!queenPlaced) {
              // backtrack: remove queen placed earlier
              // and try next square in column
              removeQueen(row, column);
              ++row;
            } // end if
          } // end if
        } // end while
        return queenPlaced;
      } // end if
    } // end placeQueens
  
    private void setQueen(int row, int column) {
    // --------------------------------------------------
    // Sets a queen at square indicated by row and 
    // column.
    // Precondition: None.
    // Postcondition: Sets the square on the board in a 
    // given row and column to QUEEN.
    // --------------------------------------------------
      // To be implemented in Programming Problem 1
    }  // end setQueen
  
    private void removeQueen(int row, int column) {
    // --------------------------------------------------
    // Removes a queen at square indicated by row and
    // column.
    // Precondition: None.
    // Postcondition: Sets the square on the board in a 
    // given row and column to EMPTY.
    // --------------------------------------------------
      // To be implemented in Programming Problem 1
    }  // end removeQueen
  
    private boolean isUnderAttack(int row, int column) {
    // --------------------------------------------------
    // Determines whether the square on the board at a 
    // given row and column is under attack by any queens 
    // in the columns 0 through column-1.
    // Precondition: Each column between 0 and column-1 
    // has a queen placed in a square at a specific row. 
    // None of these queens can be attacked by any other
    // queen.
    // Postcondition: If the designated square is under 
    // attack, returns true; otherwise, returns false.
    // --------------------------------------------------
      // To be implemented in Programming Problem 1
      return false;
    }  // end isUnderAttack
  
  } // end Queens