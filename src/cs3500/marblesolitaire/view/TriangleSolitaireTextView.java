package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * The TriangleSolitaireTextView class {@code TriangleSolitaireTextView}.
 */
public class TriangleSolitaireTextView extends AbstractMarbleSolitaireTextView {

  /**
   * The TriangleSolitaireTextView constructor.
   *
   * @param game A MarbleSolitaireModelState game state.
   * @throws IllegalArgumentException if the given MarbleSolitaireModelState is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    super(game);
  }

  /**
   * TriangleSolitaireTextView constructor used in the controller to play the game.
   *
   * @param game Board of the game to be played.
   * @param dest Appendable used to render the game.
   * @throws IllegalArgumentException Throws exception if parameters are null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game, Appendable dest)
          throws IllegalArgumentException {
    super(game, dest);
  }

  /**
   * Converts a game of TriangleSolitaire to a String.
   *
   * @return A string representing a game to TriangleSolitaire.
   */
  @Override
  public String toString() {
    StringBuilder view = new StringBuilder();
    int space = this.game.getBoardSize() - 1;
    int count = 0;
    for (int i = 0; i < this.game.getBoardSize(); i++) {
      count = space;
      if (i != 0) {
        view.append("\n");
      }
      while (count > 0) {
        view.append(" ");
        count--;
      }
      space -= 1;
      for (int j = 0; j < this.game.getBoardSize(); j++) {
        if (this.checkSlotType(i, j, MarbleSolitaireModelState.SlotState.Marble)) {
          if (j == this.game.getBoardSize() - 1) {
            view.append("O");
          } else if (j < this.game.getBoardSize() - 1
                  && checkSlotType(i, j + 1, MarbleSolitaireModelState.SlotState.Invalid)) {
            view.append("O");
          } else {
            view.append("O ");
          }
        }
        if (this.checkSlotType(i, j, MarbleSolitaireModelState.SlotState.Empty)) {
          if (j == this.game.getBoardSize() - 1) {
            view.append("_");
          } else if (j < this.game.getBoardSize() - 1
                  && checkSlotType(i, j + 1, MarbleSolitaireModelState.SlotState.Invalid)) {
            view.append("_");
          } else {
            view.append("_ ");
          }
        }
      }
    }
    return view.toString();
  }
}

