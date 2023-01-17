package cs3500.marblesolitaire.model.hw04;

/**
 * TriangleSolitaireModel class used to represent a board of MarbleSolitaire in the shape
 * of a triangle.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {
  /**
   * TriangleSolitaireModel that takes in no parameters and creates a basic board
   * with 5 armThickness and centered empty slot.
   */
  public TriangleSolitaireModel() {
    this(5);
  }

  /**
   * TriangleSolitaireModel constructor that creates a board with 3 armThickness and
   * takes in a sRow and sCol parameter to decide where the empty slot should be.
   *
   * @param sRow Row in board of empty slot.
   * @param sCol Column in board of empty slot.
   */
  public TriangleSolitaireModel(int sRow, int sCol) {
    this(5, sRow, sCol);
  }

  /**
   * TriangleSolitaireModel constructor that creates a board with the provided armThickness
   * centers the empty slot.
   *
   * @param aT armThickness provided to create board.
   */
  public TriangleSolitaireModel(int aT) {
    this(aT, 0, 0);
  }

  /**
   * TriangleSolitaireModel constructor that creates every board as every constructor defaults to
   * this one. Takes in the armThickness of the board and where the empty slot will be via
   * a sRow and sCol.
   *
   * @param aT   armThickness provided to create board.
   * @param sRow Row in board of empty slot.
   * @param sCol Column in board of empty slot.
   * @throws IllegalArgumentException if armThickness is even or the empty slot is in an invalid
   *                                  position.
   */
  public TriangleSolitaireModel(int aT, int sRow, int sCol) throws IllegalArgumentException {
    super(aT, sRow, sCol);
    this.dim = aT;
  }

  @Override
  protected SlotState[][] initBoard(int aT) {
    SlotState[][] newBoard = new SlotState[aT][aT];
    int marbs = 0;
    for (int i = 0; i < aT; i++) {
      if (i != 0) {
        marbs += 1;
      }
      for (int j = 0; j < aT; j++) {
        if (j > marbs) {
          newBoard[i][j] = SlotState.Invalid;
        } else {
          newBoard[i][j] = SlotState.Marble;
        }
      }
    }
    return newBoard;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if ((fromRow >= 0) && (fromCol >= 0) && (toRow >= 0) && (toCol >= 0) && (fromRow < this.dim)
            && (fromCol < this.dim) && (toRow < this.dim) && (toCol < this.dim)
            && board[toRow][toCol] == SlotState.Empty
            && board[fromRow][fromCol] == SlotState.Marble) {
      if ((fromRow == toRow - 2) && (toCol - 2 == fromCol)) {
        if (board[toRow - 1][toCol - 1] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, -1, -1);
          return;
        }

      }
      if ((fromRow == toRow - 2) && (toCol + 2 == fromCol)) {
        if (board[toRow - 1][toCol + 1] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, -1, 1);
          return;
        }

      }
      if ((fromRow == toRow + 2) && (toCol - 2 == fromCol)) {
        if (board[toRow + 1][toCol - 1] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, 1, -1);
          return;
        }

      }
      if ((fromRow == toRow + 2) && (toCol + 2 == fromCol)) {
        if (board[toRow + 1][toCol + 1] == SlotState.Marble) {
          doMove(fromRow, fromCol, toRow, toCol, 1, 1);
          return;
        }
      }
      super.move(fromRow, fromCol, toRow, toCol);
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.dim; i++) {
      for (int j = 0; j < this.dim; j++) {
        if (this.board[i][j] == SlotState.Marble) {
          if (i < this.dim - 2 && j < this.dim - 2) {
            if ((this.board[i + 2][j + 2] == SlotState.Empty)
                    && (this.board[i + 1][j + 1] == SlotState.Marble)) {
              return false;
            }
          }
          if (i > 1 && j > 1) {
            if ((this.board[i - 2][j - 2] == SlotState.Empty)
                    && (this.board[i - 1][j - 1] == SlotState.Marble)) {
              return false;
            }
          }
          if (j < this.dim - 2 && i > 1) {
            if ((this.board[i - 2][j + 2] == SlotState.Empty)
                    && (this.board[i - 1][j + 1] == SlotState.Marble)) {
              return false;
            }
          }
          if (j > 1 && i < this.dim - 2) {
            if ((this.board[i + 2][j - 2] == SlotState.Empty)
                    && (this.board[i + 1][j - 1] == SlotState.Marble)) {
              return false;
            }
          }
        }
      }
    }
    return super.isGameOver();
  }

  @Override
  public int getBoardSize() {
    return this.armThickness;
  }

}
