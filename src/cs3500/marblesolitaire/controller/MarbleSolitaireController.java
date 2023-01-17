package cs3500.marblesolitaire.controller;

/**
 * Interface for the MarbleSolitaire controller and its method that makes it playable.
 */
public interface MarbleSolitaireController {
  /**
   * Method used to play the EnglishSolitaire game of the controller.
   * Throws an IllegalStateException if there are no inputs in the games' scanner.
   */
  void playGame();
}
