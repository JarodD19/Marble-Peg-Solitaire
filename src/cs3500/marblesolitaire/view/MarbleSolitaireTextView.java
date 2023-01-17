package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * The MarbleSolitaireTextView class used to convert a
 * Rectilinear game of marble solitaire into
 * a visible view {@code MarbleSolitaireTextView}.
 */
public class MarbleSolitaireTextView extends AbstractMarbleSolitaireTextView {


  /**
   * The MarbleSolitaireTextView constructor used to create a view of the given
   * MarbleSolitaireState.
   *
   * @param game A MarbleSolitaireModelState game state.
   * @throws IllegalArgumentException if the given MarbleSolitaireModelState is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    super(game);
  }

  /**
   * MarbleSolitaireTextView constructor used in the controller to play the game by taking in
   * a MarbleSolitaireState and an Appendable.
   *
   * @param game Board of the game to be played.
   * @param dest Appendable used to render the game.
   * @throws IllegalArgumentException Throws exception if parameters are null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState game, Appendable dest)
          throws IllegalArgumentException {
    super(game, dest);
  }


  /**
   * Converts a rectilinear game of MarbleSolitaire to a String.
   *
   * @return A string representing a game to MarbleSolitaire.
   */
  @Override
  public String toString() {
    StringBuilder view = new StringBuilder();
    for (int i = 0; i < this.game.getBoardSize(); i++) {
      if (i != 0) {
        view.append("\n");
      }
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
        if (this.checkSlotType(i, j, MarbleSolitaireModelState.SlotState.Invalid)) {
          if ((i < ((this.game.getBoardSize() + 2) / 3)
                  && j < (((this.game.getBoardSize() + 2) / 3) - 1))
                  || (i >= ((this.game.getBoardSize() + 2) / 3)
                  + (((this.game.getBoardSize() + 2) / 3) - 1)
                  && j < ((this.game.getBoardSize() + 2) / 3) - 1)) {

            view.append("  ");
          }
        }
      }
    }
    return view.toString();
  }
}

