package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * The EnglishSolitaireModel class. {@code EnglishSolitaireModel}
 * Represents a game board of English peg solitaire
 */
public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * EnglishSolitaireModel that takes in no parameters and creates a basic board
   * with 3 armThickness and centered empty slot.
   */
  public EnglishSolitaireModel() {
    this(3);
  }

  /**
   * EnglishSolitaireModel constructor that creates a board with 3 armThickness and
   * takes in a sRow and sCol parameter to decide where the empty slot should be.
   *
   * @param sRow Row in board of empty slot.
   * @param sCol Column in board of empty slot.
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * EnglishSolitaireModel constructor that creates a board with the provided armThickness
   * centers the empty slot.
   *
   * @param aT armThickness provided to create board.
   */
  public EnglishSolitaireModel(int aT) {
    this(aT, ((aT + ((aT - 1) * 2)) / 2), ((aT + ((aT - 1) * 2)) / 2));
  }

  /**
   * EnglishSolitaireModel constructor that creates every board as every constructor defaults to
   * this one. Takes in the armThickness of the board and where the empty slot will be via
   * a sRow and sCol.
   *
   * @param aT   armThickness provided to create board.
   * @param sRow Row in board of empty slot.
   * @param sCol Column in board of empty slot.
   * @throws IllegalArgumentException if armThickness is even or the empty slot is in an invalid
   *                                  position.
   */
  public EnglishSolitaireModel(int aT, int sRow, int sCol) throws IllegalArgumentException {
    super(aT, sRow, sCol);
    if ((aT % 2) != 1) {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Creates a board with the given armThickness.
   *
   * @param aT armThickness of the board to be created.
   * @return Returns the created board.
   */
  @Override
  protected SlotState[][] initBoard(int aT) {
    SlotState[][] newBoard = new SlotState[aT + (aT - 1) * 2][aT + (aT - 1) * 2];
    for (int i = 0; i < aT + (aT - 1) * 2; i++) {
      for (int j = 0; j < aT + (aT - 1) * 2; j++) {
        if ((i < (aT - 1) && j < (aT - 1)) || (i >= aT + (aT - 1) && j < aT - 1)
                || (i >= aT + (aT - 1) && j >= aT + (aT - 1))
                || (i < aT - 1 && j >= aT + (aT - 1))) {
          newBoard[i][j] = SlotState.Invalid;
        } else {
          newBoard[i][j] = SlotState.Marble;
        }
      }
    }
    return newBoard;
  }
}
