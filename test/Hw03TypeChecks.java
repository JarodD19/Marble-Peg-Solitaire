import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;

/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class Hw03TypeChecks {
  /**
   * Used to make sure code compiles correctly. Java Style points.
   * @param args Arguments.
   */
  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helper(new EnglishSolitaireModel(),
            rd, ap);
    helper(new EnglishSolitaireModel(3, 3), rd, ap);
  }

  /**
   * Used to make sure code compiles correctly. Java Style points.
   * @param model Models.
   * @param rd rds.
   * @param ap aps.
   */
  private static void helper(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel model,
                             Readable rd, Appendable ap) {
    new cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl(model,
            new cs3500.marblesolitaire.view.MarbleSolitaireTextView(model, ap), rd);
  }

}
