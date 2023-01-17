import java.util.Objects;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * MockMarbleSolitaire class used to test the controller.
 */
public class MockMarbleSolitaire implements MarbleSolitaireModel {
  private StringBuilder log;

  /**
   * Mock constructor to take in a log used to test.
   *
   * @param log Appendable used to test the controller.
   */
  public MockMarbleSolitaire(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * Returns the positions the Controller sends to the move method.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException N/A.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(fromRow).append(" ").append(fromCol).append(" ").append(toRow).append(" ")
            .append(toCol);
  }

  /**
   * Returns false. Unused.
   *
   * @return false.
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Returns 0. Unused.
   *
   * @return 0.
   */
  @Override
  public int getBoardSize() {
    return 0;
  }

  /**
   * Returns null. Unused.
   *
   * @return null.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  /**
   * Returns 0. Unused.
   *
   * @return 0.
   */
  @Override
  public int getScore() {
    return 0;
  }
}
