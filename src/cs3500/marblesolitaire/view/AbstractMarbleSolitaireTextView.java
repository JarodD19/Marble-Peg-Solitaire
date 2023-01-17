package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * The AbstractMarbleSolitaireTextView class used to abstarct the view of different peg
 * solitaire boards.{@codeAbstractMarbleSolitaireTextView}.
 */
public abstract class AbstractMarbleSolitaireTextView implements MarbleSolitaireView {

  protected MarbleSolitaireModelState game;

  protected Appendable dest;

  /**
   * The AbstractMarbleSolitaireTextView constructor.
   *
   * @param game A MarbleSolitaireModelState game state.
   * @throws IllegalArgumentException if the given MarbleSolitaireModelState is null.
   */
  public AbstractMarbleSolitaireTextView(MarbleSolitaireModelState game)
          throws IllegalArgumentException {
    if (game == null) {
      throw new IllegalArgumentException();
    } else {
      this.game = game;
      this.dest = System.out;
    }
  }

  /**
   * AbstractMarbleSolitaireTextView constructor used in the controller to play the game.
   *
   * @param game Board of the game to be played.
   * @param dest Appendable used to render the game.
   * @throws IllegalArgumentException Throws exception if parameters are null.
   */
  public AbstractMarbleSolitaireTextView(MarbleSolitaireModelState game, Appendable dest)
          throws IllegalArgumentException {
    if (game == null || dest == null) {
      throw new IllegalArgumentException();
    } else {
      this.game = game;
      this.dest = dest;
    }
  }

  /**
   * Checks whether the given slot is equal to the given SlotState.
   *
   * @param r    Row of slot.
   * @param c    Column of slot.
   * @param slot SlotState expected.
   * @return True if the SlotStates match, false if not.
   */
  protected boolean checkSlotType(int r, int c, MarbleSolitaireModelState.SlotState slot) {
    return this.game.getSlotAt(r, c) == slot;
  }

  /**
   * Converts a game of MarbleSolitaire to a String.
   *
   * @return A string representing a game of MarbleSolitaire.
   */

  public abstract String toString();

  /**
   * Adds the current board to the controller views appendable,
   * making the board visible in the game.
   *
   * @throws IOException Throws exception when appendable is invalid.
   */
  @Override
  public void renderBoard() throws IOException {
    dest.append(this.toString());
  }

  /**
   * Add the given message to the appendable, making it visible in the game.
   *
   * @param message the message to be transmitted
   * @throws IOException Throws exception when appendable is invalid.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    dest.append(message);
  }
}

