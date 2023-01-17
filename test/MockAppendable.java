import java.io.IOException;

/**
 * MockAppendable used to test controller.
 */
public class MockAppendable implements Appendable {
  /**
   * Mock method used to test controller.
   * @param csq
   *         The character sequence to append.  If {@code csq} is
   *         {@code null}, then the four characters {@code "null"} are
   *         appended to this Appendable.
   *
   * @return Nothing.
   * @throws IOException To test controller.
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  /**
   * Mock method used to test controller.
   * @param csq
   *         The character sequence from which a subsequence will be
   *         appended.  If {@code csq} is {@code null}, then characters
   *         will be appended as if {@code csq} contained the four
   *         characters {@code "null"}.
   *
   * @param start
   *         The index of the first character in the subsequence
   *
   * @param end
   *         The index of the character following the last character in the
   *         subsequence
   *
   * @return Nothing.
   * @throws IOException To test controller.
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  /**
   * Mock method used to test controller.
   * @param c
   *         The character to append
   *
   * @return Nothing.
   * @throws IOException to test controller.
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
