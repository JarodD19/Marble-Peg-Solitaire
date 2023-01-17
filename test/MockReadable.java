import java.io.IOException;
import java.nio.CharBuffer;

/**
 * MockReadable class used to test the controller.
 */
public class MockReadable implements Readable {
  /**
   * Mock read method throws IOException to test controller.
   * @param cb the buffer to read characters into
   * @return Nothing.
   * @throws IOException to test controller.
   */
  @Override
  public int read(CharBuffer cb) throws IOException {
    throw new IOException();
  }
}
