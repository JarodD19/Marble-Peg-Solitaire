package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * Main class used to play the game.
 */
public class MarbleSolitaire {
  /**
   * Main method used to run the playGame method on the controller and provide input.
   *
   * @param args arguments for the method.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel game1 = null;
    MarbleSolitaireView view1 = null;
    Readable input = new InputStreamReader(System.in);
    Appendable out = System.out;
    MarbleSolitaireControllerImpl controller = null;
    int size = -1;
    int row = -1;
    int col = -1;
    ModelType.ModelShape gameType = null;

    for (int i = 0; i < args.length; i++) {
      String str = args[i];
      switch (str.toLowerCase()) {
        case "english":
          gameType = ModelType.ModelShape.ENGLISH;
          break;
        case "european":
          gameType = ModelType.ModelShape.EUROPEAN;
          break;
        case "triangular":
          gameType = ModelType.ModelShape.TRIANGULAR;
          break;
        case "-size":
          try {
            size = Integer.parseInt(args[i + 1]);
          } catch (NumberFormatException e) {
            //Do not need to handle
          }
          break;
        case "-hole":
          try {
            row = Integer.parseInt(args[i + 1]);
            row = Integer.parseInt(args[i + 2]);
          } catch (NumberFormatException e) {
            //Do not need to handle
          }
          break;
        default:
          gameType = null;
          controller = null;
      }
    }

    switch (gameType) {
      case ENGLISH:
        if (size != -1 && row != -1) {
          game1 = new EnglishSolitaireModel(size, row, col);
        } else if (size != -1 && row == -1) {
          game1 = new EnglishSolitaireModel(size);
        } else if (size == -1 && row != -1) {
          game1 = new EnglishSolitaireModel(row, col);
        } else if (size == -1 && row == -1) {
          game1 = new EnglishSolitaireModel();
        }
        view1 = new MarbleSolitaireTextView(game1);
        controller = new MarbleSolitaireControllerImpl(game1, view1, input);
        break;

      case EUROPEAN:
        if (size != -1 && row != -1) {
          game1 = new EuropeanSolitaireModel(size, row, col);
        } else if (size != -1 && row == -1) {
          game1 = new EuropeanSolitaireModel(size);
        } else if (size == -1 && row != -1) {
          game1 = new EuropeanSolitaireModel(row, col);
        } else if (size == -1 && row == -1) {
          game1 = new EuropeanSolitaireModel();
        }
        view1 = new MarbleSolitaireTextView(game1);
        controller = new MarbleSolitaireControllerImpl(game1, view1, input);
        break;

      case TRIANGULAR:
        if (size != -1 && row != -1) {
          game1 = new TriangleSolitaireModel(size, row, col);
        } else if (size != -1 && row == -1) {
          game1 = new TriangleSolitaireModel(size);
        } else if (size == -1 && row != -1) {
          game1 = new TriangleSolitaireModel(row, col);
        } else if (size == -1 && row == -1) {
          game1 = new TriangleSolitaireModel();
        }
        view1 = new TriangleSolitaireTextView(game1);
        controller = new MarbleSolitaireControllerImpl(game1, view1, input);
        break;

      default:
        game1 = null;
        view1 = null;
        controller = null;
    }

    assert controller != null;
    controller.playGame();
  }
}
