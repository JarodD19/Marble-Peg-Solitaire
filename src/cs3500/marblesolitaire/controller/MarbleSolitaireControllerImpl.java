package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * Implementation of the MarbleSolitaire controller used to play the game. Takes in a version of
 * the board as a MarbleSolitaireModel, its view as a MarbleSolitaireView, and uses the users
 * input to play.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private MarbleSolitaireModel game;

  private MarbleSolitaireView view;

  private Readable input;

  /**
   * Method used to play a peg Solitaire game of this controller. Handles user input,
   * determines whether inputs are valid, throws exceptions if there is no inputs,
   * catches exceptions from helpers, and renders parts of the game at the appropriate time.
   */
  @Override
  public void playGame() {
    int fromRow = 0;
    int fromCol = 0;
    int toRow = 0;
    int toCol = 0;
    Scanner scan = new Scanner(input);
    this.renderGame();
    while (!this.game.isGameOver()) {
      if (scan.hasNext()) {
        String val = scan.next();
        if (checkValidNum(val)) {
          if (fromRow == 0) {
            fromRow = Integer.parseInt(val);
          } else if (fromCol == 0) {
            fromCol = Integer.parseInt(val);
          } else if (toRow == 0) {
            toRow = Integer.parseInt(val);
          } else if (toCol == 0) {
            toCol = Integer.parseInt(val);
            try {
              makeMove(fromRow, fromCol, toRow, toCol);
              renderGame();
              fromRow = 0;
              fromCol = 0;
              toRow = 0;
              toCol = 0;
            } catch (IllegalArgumentException e) {
              writeMessage("Invalid move. Play again. This move can not be made."
                      + System.lineSeparator());
              fromRow = 0;
              fromCol = 0;
              toRow = 0;
              toCol = 0;
            }
          }
        } else if (val.equalsIgnoreCase("q")) {
          writeMessage("Game quit!" + System.lineSeparator() + "State of game when quit:"
                  + System.lineSeparator());
          renderGame();
          break;
        } else {
          writeMessage("Fix inputs." + System.lineSeparator());
        }
      } else {
        throw new IllegalStateException("No inputs");
      }
    }
    if (this.game.isGameOver()) {
      writeMessage("Game over!" + System.lineSeparator());
      renderGame();
    }
  }

  /**
   * Constructor for a MarbleSolitaire Controller.
   *
   * @param game  Board used in the game.
   * @param view  MarbleSolitaireTextView used to render the game.
   * @param input User input to make moves and quit.
   * @throws IllegalArgumentException Throws exception if the parameters entered are null.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel game, MarbleSolitaireView view,
                                       Readable input)
          throws IllegalArgumentException {
    if (game == null || input == null || view == null) {
      throw new IllegalArgumentException();
    } else {
      this.game = game;
      this.input = input;
      this.view = view;
    }
  }

  /**
   * Helper used to render board and score as well as catch and throw exceptions.
   */
  private void renderGame() {
    try {
      this.view.renderBoard();
      this.writeMessage(System.lineSeparator() + "Score: " + this.game.getScore()
              + System.lineSeparator());
    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * Helper used to render messages as well as catch and throw exceptions.
   */
  private void writeMessage(String message) throws IllegalStateException {
    try {
      this.view.renderMessage(message);

    } catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }

  /**
   * Helper used to check whether user input is valid number, if not, catches the exception
   * and returns false.
   *
   * @param s String inputted by user.
   * @return true if the input is a valid number, false if not.
   */
  private boolean checkValidNum(String s) {
    try {
      return Integer.parseInt(s) > 0;

    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Helper used to convert inputs to actual coordinates and make the move on the board.
   *
   * @param fromRow Row of marble to be moved.
   * @param fromCol Column of marble to be moved.
   * @param toRow   Row of destination of marble.
   * @param toCol   Column of destination of marble.
   */
  private void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
    this.game.move(fromRow - 1, fromCol - 1, toRow - 1, toCol - 1);
  }
}
