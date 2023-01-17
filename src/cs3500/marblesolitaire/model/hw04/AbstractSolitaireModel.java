package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Abstract class AbstractSolitaireModel represents the methods used by all
 * MarbleSolitaireStates and abstracts the code from each concrete class.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected int armThickness; //Thickness of marbles in the last row of the board
  protected SlotState[][] board; //Int array representing the pieces on the board

  protected int dim; //Dimensions of the board

  /**
   * This is the AbstractSolitaireModel constructor for AbstractSolitaireModel objects
   * which takes in the thickness of the bottom row of the Model and the row and column of the hole.
   *
   * @param aT   thickness of the bottom row of the Model .
   * @param sRow Row of the hole in the board.
   * @param sCol Column of the hole on the board.
   * @throws IllegalArgumentException if an input is invalid (Contradicts the rules of the game or
   *                                  is not a possible parameter).
   */
  public AbstractSolitaireModel(int aT, int sRow, int sCol) throws IllegalArgumentException {
    if (aT > 0) {
      this.armThickness = aT;
      this.board = initBoard(aT);
      this.dim = aT + (aT - 1) * 2;
    } else {
      throw new IllegalArgumentException();
    }
    if (getSlotAt(sRow, sCol) == SlotState.Marble) {
      this.board[sRow][sCol] = SlotState.Empty;
    } else {
      throw new IllegalArgumentException();
    }
  }

  protected abstract SlotState[][] initBoard(int aT);

  /**
   * Allows for moving of marbles on the game board within certain restrictions.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is against the rules of the game.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (checkMove(fromRow, fromCol, toRow, toCol)) {
      if ((fromRow == toRow - 2) && toCol == fromCol) {
        if (board[toRow - 1][toCol] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, -1, 0);
          return;
        }

      }
      if ((fromRow == toRow + 2) && toCol == fromCol) {
        if (board[toRow + 1][toCol] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, 1, 0);
          return;
        }
      }
      if ((fromCol == toCol - 2) && fromRow == toRow) {
        if (board[toRow][toCol - 1] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, 0, -1);
          return;
        }
      }
      if ((fromCol == toCol + 2) && fromRow == toRow) {
        if (board[toRow][toCol + 1] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, 0, 1);
          return;
        }
      }
    }
    throw new IllegalArgumentException("This is not a legal move!");
  }

  /**
   * Checks whether the game is over, if no legal moves are left.
   *
   * @return Returns true if there are no more moves left and false if there are moves left.
   */
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.dim; i++) {
      for (int j = 0; j < this.dim; j++) {
        if (this.board[i][j] == SlotState.Marble) {
          if (i < this.dim - 2) {
            if ((this.board[i + 2][j] == SlotState.Empty)
                    && (this.board[i + 1][j] == SlotState.Marble)) {
              return false;
            }
          }
          if (i > 1) {
            if ((this.board[i - 2][j] == SlotState.Empty)
                    && (this.board[i - 1][j] == SlotState.Marble)) {
              return false;
            }
          }
          if (j < this.dim - 2) {
            if ((this.board[i][j + 2] == SlotState.Empty)
                    && (this.board[i][j + 1] == SlotState.Marble)) {
              return false;
            }
          }
          if (j > 1) {
            if ((this.board[i][j - 2] == SlotState.Empty)
                    && (this.board[i][j - 1] == SlotState.Marble)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * Returns the size of one side of the board.
   *
   * @return the size of the board.
   */
  @Override
  public int getBoardSize() {
    return this.dim;
  }

  /**
   * Checks to see what is at the given position on the board.
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return The state of the slot at the given position (Marble, Empty, Invalid).
   * @throws IllegalArgumentException if provided slot is not on the given board.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if ((row >= 0) && (col >= 0) && (row < this.getBoardSize()) && (col < this.getBoardSize())) {
      return board[row][col];
    } else {
      throw new IllegalArgumentException("This position is beyond the dimensions of the board!");
    }
  }

  /**
   * Gives the score of the current game.
   *
   * @return The amount of marbles left on the board.
   */
  @Override
  public int getScore() {
    int count = 0;
    for (SlotState[] slots : this.board) {
      for (SlotState indSlot : slots) {
        if (indSlot == SlotState.Marble) {
          count += 1;
        }
      }
    }
    return count;
  }

  protected boolean checkMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (fromRow >= 0) && (fromCol >= 0) && (toRow >= 0) && (toCol >= 0) && (fromRow < this.dim)
            && (fromCol < this.dim) && (toRow < this.dim) && (toCol < this.dim)
            && !((fromRow == toRow - 2) && (fromCol == toCol - 2))
            && board[toRow][toCol] == SlotState.Empty
            && board[fromRow][fromCol] == SlotState.Marble;
  }

  protected void doMove(int fromRow, int fromCol, int toRow, int toCol, int inc1, int inc2) {
    board[toRow][toCol] = SlotState.Marble;
    board[fromRow][fromCol] = SlotState.Empty;
    board[toRow + inc1][toCol + inc2] = SlotState.Empty;
  }
}
