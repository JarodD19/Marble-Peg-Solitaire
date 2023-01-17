import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Class testing the {@code MarbleSolitaireControllerImpl} and all the edge cases.
 */
public class MarbleSolitaireControllerTest {

  MarbleSolitaireModel board1;

  MarbleSolitaireModel board2;

  MarbleSolitaireModel board3;

  MarbleSolitaireModel board4;

  Appendable out;

  Appendable out2;

  Appendable out3;

  Readable mTInput;

  MockAppendable mockOut;

  MockReadable mockIn;

  MarbleSolitaireView view1;

  MarbleSolitaireView view2;

  MarbleSolitaireView view3;

  MarbleSolitaireModel mockBoard;

  StringBuilder log;

  @Before
  public void setup() {
    board1 = new EnglishSolitaireModel();
    board2 = new EuropeanSolitaireModel();
    board3 = new TriangleSolitaireModel();
    board4 = new EuropeanSolitaireModel(3, 1, 3);
    out = new StringBuilder();
    out2 = new StringBuilder();
    out3 = new StringBuilder();
    mTInput = new StringReader("");
    mockOut = new MockAppendable();
    mockIn = new MockReadable();
    view1 = new MarbleSolitaireTextView(board1, out);
    view2 = new MarbleSolitaireTextView(board2, out);
    view3 = new TriangleSolitaireTextView(board3, out);
  }

  @Test
  public void testControllerInit() {
    try {
      new MarbleSolitaireControllerImpl(board1, view1, null);
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(board1, null, new StringReader("4 2 4 4 q"));
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(null, view1, new StringReader("4 2 4 4 q"));
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(board2, view2, null);
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(board2, null, new StringReader("4 2 4 4 q"));
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(null, view2, new StringReader("4 2 4 4 q"));
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(board3, view3, null);
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(board3, null, new StringReader("4 2 4 4 q"));
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }
    try {
      new MarbleSolitaireControllerImpl(null, view3, new StringReader("4 2 4 4 q"));
      fail("Invalid Initialization");
    } catch (IllegalArgumentException e) {
      // Throws argument when parameter is null
    }

  }

  @Test
  public void testMockAppendable() {
    try {
      new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, mockOut),
              new StringReader("4 2 4 4 q")).playGame();
      fail("IOException thrown and caught by controller, throwing an IllegalStateException");

    } catch (IllegalStateException e) {
      // IllegalStateException thrown and caught indicating the IOException handled correctly
    }
    try {
      new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, mockOut),
              new StringReader("4 2 4 4 q")).playGame();
      fail("IOException thrown and caught by controller, throwing an IllegalStateException");

    } catch (IllegalStateException e) {
      // IllegalStateException thrown and caught indicating the IOException handled correctly
    }
    try {
      new MarbleSolitaireControllerImpl(board3, new MarbleSolitaireTextView(board3, mockOut),
              new StringReader("4 2 4 4 q")).playGame();
      fail("IOException thrown and caught by controller, throwing an IllegalStateException");

    } catch (IllegalStateException e) {
      // IllegalStateException thrown and caught indicating the IOException handled correctly
    }
  }

  @Test
  public void testMockReadable() {
    try {
      new MarbleSolitaireControllerImpl(board1,
              new MarbleSolitaireTextView(board1, out), mockIn).playGame();
      fail("IOException thrown and caught by controller, throwing an IllegalStateException");

    } catch (IllegalStateException e) {
      // IllegalStateException thrown and caught indicating the IOException handled correctly
    }
    try {
      new MarbleSolitaireControllerImpl(board2,
              new MarbleSolitaireTextView(board2, out), mockIn).playGame();
      fail("IOException thrown and caught by controller, throwing an IllegalStateException");

    } catch (IllegalStateException e) {
      // IllegalStateException thrown and caught indicating the IOException handled correctly
    }
    try {
      new MarbleSolitaireControllerImpl(board3,
              new MarbleSolitaireTextView(board3, out), mockIn).playGame();
      fail("IOException thrown and caught by controller, throwing an IllegalStateException");

    } catch (IllegalStateException e) {
      // IllegalStateException thrown and caught indicating the IOException handled correctly
    }
  }

  @Test
  public void testMockMarbleSolitaire() {
    log = new StringBuilder();
    mockBoard = new MockMarbleSolitaire(log);
    new MarbleSolitaireControllerImpl(mockBoard, new MarbleSolitaireTextView(mockBoard, out),
            new StringReader("4 2 4 4 q")).playGame();
    assertEquals("3 1 3 3", log.toString());
  }

  @Test
  public void testStartQuit() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("q")).playGame();
    assertEquals("Game quit!\r", out.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[9]);
    assertEquals("    O O O", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out.toString().split("\n")[14]);
    assertEquals("    O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O\r", out.toString().split("\n")[16]);
    assertEquals("Score: 32\r", out.toString().split("\n")[17]);
    out = new StringBuilder();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("Q")).playGame();
    assertEquals("Game quit!\r", out.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[9]);
    assertEquals("    O O O", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out.toString().split("\n")[14]);
    assertEquals("    O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O\r", out.toString().split("\n")[16]);
    assertEquals("Score: 32\r", out.toString().split("\n")[17]);
    out = new StringBuilder();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("q")).playGame();
    assertEquals("Game quit!\r", out2.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[9]);
    assertEquals("    O O O", out2.toString().split("\n")[10]);
    assertEquals("  O O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[14]);
    assertEquals("  O O O O O", out2.toString().split("\n")[15]);
    assertEquals("    O O O\r", out2.toString().split("\n")[16]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[17]);
    out2 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("Q")).playGame();
    assertEquals("Game quit!\r", out2.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[9]);
    assertEquals("    O O O", out2.toString().split("\n")[10]);
    assertEquals("  O O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[14]);
    assertEquals("  O O O O O", out2.toString().split("\n")[15]);
    assertEquals("    O O O\r", out2.toString().split("\n")[16]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[17]);
    out2 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("q")).playGame();
    assertEquals("Game quit!\r", out3.toString().split("\n")[6]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[7]);
    assertEquals("    _", out3.toString().split("\n")[8]);
    assertEquals("   O O", out3.toString().split("\n")[9]);
    assertEquals("  O O O", out3.toString().split("\n")[10]);
    assertEquals(" O O O O", out3.toString().split("\n")[11]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[12]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[13]);
    out3 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("Q")).playGame();
    assertEquals("Game quit!\r", out3.toString().split("\n")[6]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[7]);
    assertEquals("    _", out3.toString().split("\n")[8]);
    assertEquals("   O O", out3.toString().split("\n")[9]);
    assertEquals("  O O O", out3.toString().split("\n")[10]);
    assertEquals(" O O O O", out3.toString().split("\n")[11]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[12]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[13]);
    out3 = new StringBuilder();
  }

  @Test
  public void testInvalidInputs() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("j q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("    O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O", out.toString().split("\n")[16]);
    assertEquals("    O O O\r", out.toString().split("\n")[17]);
    assertEquals("Score: 32\r", out.toString().split("\n")[18]);
    out = new StringBuilder();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("@ q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("    O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O", out.toString().split("\n")[16]);
    assertEquals("    O O O\r", out.toString().split("\n")[17]);
    assertEquals("Score: 32\r", out.toString().split("\n")[18]);
    out = new StringBuilder();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("-1 2 3 4 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("    O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O", out.toString().split("\n")[16]);
    assertEquals("    O O O\r", out.toString().split("\n")[17]);
    assertEquals("Score: 32\r", out.toString().split("\n")[18]);
    out = new StringBuilder();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("-1 w 4 4 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("Fix inputs.\r", out.toString().split("\n")[9]);
    assertEquals("Game quit!\r", out.toString().split("\n")[10]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[11]);
    assertEquals("    O O O", out.toString().split("\n")[12]);
    assertEquals("    O O O", out.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out.toString().split("\n")[14]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[15]);
    assertEquals("O O O O O O O", out.toString().split("\n")[16]);
    assertEquals("    O O O", out.toString().split("\n")[17]);
    assertEquals("    O O O\r", out.toString().split("\n")[18]);
    assertEquals("Score: 32\r", out.toString().split("\n")[19]);
    out = new StringBuilder();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("4 4 2-1 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("    O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O", out.toString().split("\n")[16]);
    assertEquals("    O O O\r", out.toString().split("\n")[17]);
    assertEquals("Score: 32\r", out.toString().split("\n")[18]);
    out = new StringBuilder();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("3 -1 2 3 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("    O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O", out.toString().split("\n")[16]);
    assertEquals("    O O O\r", out.toString().split("\n")[17]);
    assertEquals("Score: 32\r", out.toString().split("\n")[18]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("j q")).playGame();
    assertEquals("Fix inputs.\r", out2.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[10]);
    assertEquals("    O O O", out2.toString().split("\n")[11]);
    assertEquals("  O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[15]);
    assertEquals("  O O O O O", out2.toString().split("\n")[16]);
    assertEquals("    O O O\r", out2.toString().split("\n")[17]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[18]);
    out2 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("! q")).playGame();
    assertEquals("Fix inputs.\r", out2.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[10]);
    assertEquals("    O O O", out2.toString().split("\n")[11]);
    assertEquals("  O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[15]);
    assertEquals("  O O O O O", out2.toString().split("\n")[16]);
    assertEquals("    O O O\r", out2.toString().split("\n")[17]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[18]);
    out2 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("1 2 4 q")).playGame();
    assertEquals("Game quit!\r", out2.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[9]);
    assertEquals("    O O O", out2.toString().split("\n")[10]);
    assertEquals("  O O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[14]);
    assertEquals("  O O O O O", out2.toString().split("\n")[15]);
    assertEquals("    O O O\r", out2.toString().split("\n")[16]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[17]);
    out2 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 3 q 4")).playGame();
    assertEquals("Game quit!\r", out2.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[9]);
    assertEquals("    O O O", out2.toString().split("\n")[10]);
    assertEquals("  O O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[14]);
    assertEquals("  O O O O O", out2.toString().split("\n")[15]);
    assertEquals("    O O O\r", out2.toString().split("\n")[16]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[17]);
    out2 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 q 3 4 4")).playGame();
    assertEquals("Game quit!\r", out2.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[9]);
    assertEquals("    O O O", out2.toString().split("\n")[10]);
    assertEquals("  O O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[14]);
    assertEquals("  O O O O O", out2.toString().split("\n")[15]);
    assertEquals("    O O O\r", out2.toString().split("\n")[16]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[17]);
    out2 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("q 2 3 3")).playGame();
    assertEquals("Game quit!\r", out2.toString().split("\n")[8]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[9]);
    assertEquals("    O O O", out2.toString().split("\n")[10]);
    assertEquals("  O O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[13]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[14]);
    assertEquals("  O O O O O", out2.toString().split("\n")[15]);
    assertEquals("    O O O\r", out2.toString().split("\n")[16]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[17]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("j q")).playGame();
    assertEquals("Fix inputs.\r", out3.toString().split("\n")[6]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[7]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[8]);
    assertEquals("    _", out3.toString().split("\n")[9]);
    assertEquals("   O O", out3.toString().split("\n")[10]);
    assertEquals("  O O O", out3.toString().split("\n")[11]);
    assertEquals(" O O O O", out3.toString().split("\n")[12]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[13]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[14]);
    out3 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("! q")).playGame();
    assertEquals("Fix inputs.\r", out3.toString().split("\n")[6]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[7]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[8]);
    assertEquals("    _", out3.toString().split("\n")[9]);
    assertEquals("   O O", out3.toString().split("\n")[10]);
    assertEquals("  O O O", out3.toString().split("\n")[11]);
    assertEquals(" O O O O", out3.toString().split("\n")[12]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[13]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[14]);
    out3 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("1 2 4 q")).playGame();
    assertEquals("Game quit!\r", out3.toString().split("\n")[6]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[7]);
    assertEquals("    _", out3.toString().split("\n")[8]);
    assertEquals("   O O", out3.toString().split("\n")[9]);
    assertEquals("  O O O", out3.toString().split("\n")[10]);
    assertEquals(" O O O O", out3.toString().split("\n")[11]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[12]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[13]);
    out3 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("2 3 q 4")).playGame();
    assertEquals("Game quit!\r", out3.toString().split("\n")[6]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[7]);
    assertEquals("    _", out3.toString().split("\n")[8]);
    assertEquals("   O O", out3.toString().split("\n")[9]);
    assertEquals("  O O O", out3.toString().split("\n")[10]);
    assertEquals(" O O O O", out3.toString().split("\n")[11]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[12]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[13]);
    out3 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("2 q 3 4 4")).playGame();
    assertEquals("Game quit!\r", out3.toString().split("\n")[6]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[7]);
    assertEquals("    _", out3.toString().split("\n")[8]);
    assertEquals("   O O", out3.toString().split("\n")[9]);
    assertEquals("  O O O", out3.toString().split("\n")[10]);
    assertEquals(" O O O O", out3.toString().split("\n")[11]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[12]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[13]);
    out3 = new StringBuilder();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("q 2 3 3")).playGame();
    assertEquals("Game quit!\r", out3.toString().split("\n")[6]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[7]);
    assertEquals("    _", out3.toString().split("\n")[8]);
    assertEquals("   O O", out3.toString().split("\n")[9]);
    assertEquals("  O O O", out3.toString().split("\n")[10]);
    assertEquals(" O O O O", out3.toString().split("\n")[11]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[12]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[13]);
  }


  @Test
  public void testValidFullGame() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("4 2 4 4 q")).playGame();
    assertEquals("    O O O", out.toString().split("\n")[0]);
    assertEquals("    O O O", out.toString().split("\n")[1]);
    assertEquals("O O O O O O O", out.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[3]);
    assertEquals("O O O O O O O", out.toString().split("\n")[4]);
    assertEquals("    O O O", out.toString().split("\n")[5]);
    assertEquals("    O O O\r", out.toString().split("\n")[6]);
    assertEquals("Score: 32\r", out.toString().split("\n")[7]);
    assertEquals("    O O O", out.toString().split("\n")[8]);
    assertEquals("    O O O", out.toString().split("\n")[9]);
    assertEquals("O O O O O O O", out.toString().split("\n")[10]);
    assertEquals("O _ _ O O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("    O O O", out.toString().split("\n")[13]);
    assertEquals("    O O O\r", out.toString().split("\n")[14]);
    assertEquals("Score: 31\r", out.toString().split("\n")[15]);
    assertEquals("Game quit!\r", out.toString().split("\n")[16]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[17]);
    assertEquals("    O O O", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("O O O O O O O", out.toString().split("\n")[20]);
    assertEquals("O _ _ O O O O", out.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out.toString().split("\n")[22]);
    assertEquals("    O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O\r", out.toString().split("\n")[24]);
    assertEquals("Score: 31\r", out.toString().split("\n")[25]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("4 2 4 4 q")).playGame();
    assertEquals("    O O O", out2.toString().split("\n")[0]);
    assertEquals("  O O O O O", out2.toString().split("\n")[1]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[2]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[3]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[4]);
    assertEquals("  O O O O O", out2.toString().split("\n")[5]);
    assertEquals("    O O O\r", out2.toString().split("\n")[6]);
    assertEquals("Score: 36\r", out2.toString().split("\n")[7]);
    assertEquals("    O O O", out2.toString().split("\n")[8]);
    assertEquals("  O O O O O", out2.toString().split("\n")[9]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[10]);
    assertEquals("O _ _ O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("  O O O O O", out2.toString().split("\n")[13]);
    assertEquals("    O O O\r", out2.toString().split("\n")[14]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[15]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[16]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[17]);
    assertEquals("    O O O", out2.toString().split("\n")[18]);
    assertEquals("  O O O O O", out2.toString().split("\n")[19]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[20]);
    assertEquals("O _ _ O O O O", out2.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[22]);
    assertEquals("  O O O O O", out2.toString().split("\n")[23]);
    assertEquals("    O O O\r", out2.toString().split("\n")[24]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[25]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 1 1 1 q")).playGame();
    assertEquals("    _", out3.toString().split("\n")[0]);
    assertEquals("   O O", out3.toString().split("\n")[1]);
    assertEquals("  O O O", out3.toString().split("\n")[2]);
    assertEquals(" O O O O", out3.toString().split("\n")[3]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[4]);
    assertEquals("Score: 14\r", out3.toString().split("\n")[5]);
    assertEquals("    O", out3.toString().split("\n")[6]);
    assertEquals("   _ O", out3.toString().split("\n")[7]);
    assertEquals("  _ O O", out3.toString().split("\n")[8]);
    assertEquals(" O O O O", out3.toString().split("\n")[9]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[10]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[11]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[12]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[13]);
    assertEquals("    O", out3.toString().split("\n")[14]);
    assertEquals("   _ O", out3.toString().split("\n")[15]);
    assertEquals("  _ O O", out3.toString().split("\n")[16]);
    assertEquals(" O O O O", out3.toString().split("\n")[17]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[18]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[19]);

  }

  @Test
  public void testValidQuit() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("4 6 4 4 q")).playGame();
    assertEquals("Game quit!\r", out.toString().split("\n")[16]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[17]);
    assertEquals("    O O O", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("O O O O O O O", out.toString().split("\n")[20]);
    assertEquals("O O O O _ _ O", out.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out.toString().split("\n")[22]);
    assertEquals("    O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O\r", out.toString().split("\n")[24]);
    assertEquals("Score: 31\r", out.toString().split("\n")[25]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("4 2 4 4 q")).playGame();
    assertEquals("Game quit!\r", out2.toString().split("\n")[16]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[17]);
    assertEquals("    O O O", out2.toString().split("\n")[18]);
    assertEquals("  O O O O O", out2.toString().split("\n")[19]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[20]);
    assertEquals("O _ _ O O O O", out2.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[22]);
    assertEquals("  O O O O O", out2.toString().split("\n")[23]);
    assertEquals("    O O O\r", out2.toString().split("\n")[24]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[25]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 1 1 1 q")).playGame();
    assertEquals("Game quit!\r", out3.toString().split("\n")[12]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[13]);
    assertEquals("    O", out3.toString().split("\n")[14]);
    assertEquals("   _ O", out3.toString().split("\n")[15]);
    assertEquals("  _ O O", out3.toString().split("\n")[16]);
    assertEquals(" O O O O", out3.toString().split("\n")[17]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[18]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[19]);

  }

  @Test
  public void testInvalidMove() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("4 2 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("4 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("2 4 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("2 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("8 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("4 2 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out2.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("4 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out2.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 4 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out2.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out2.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("8 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out2.toString().split("\n")[8]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("4 2 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out3.toString().split("\n")[6]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("4 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out3.toString().split("\n")[6]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("2 4 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out3.toString().split("\n")[6]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("2 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out3.toString().split("\n")[6]);
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("8 6 4 3 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out3.toString().split("\n")[6]);
  }


  @Test
  public void testValidQuitWithInvalidMove() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("6 6 4 4 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out.toString().split("\n")[8]);
    assertEquals("Game quit!\r", out.toString().split("\n")[9]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[10]);
    assertEquals("    O O O", out.toString().split("\n")[11]);
    assertEquals("    O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[14]);
    assertEquals("O O O O O O O", out.toString().split("\n")[15]);
    assertEquals("    O O O", out.toString().split("\n")[16]);
    assertEquals("    O O O\r", out.toString().split("\n")[17]);
    assertEquals("Score: 32\r", out.toString().split("\n")[18]);
  }

  @Test
  public void testValidMoveWithInvalidMove() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("6 6 4 4 4 2 4 4 q")).playGame();
    assertEquals("Invalid move. Play again. This move can not be made.\r",
            out.toString().split("\n")[8]);
    assertEquals("    O O O", out.toString().split("\n")[9]);
    assertEquals("    O O O", out.toString().split("\n")[10]);
    assertEquals("O O O O O O O", out.toString().split("\n")[11]);
    assertEquals("O _ _ O O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("    O O O", out.toString().split("\n")[14]);
    assertEquals("    O O O\r", out.toString().split("\n")[15]);
    assertEquals("Score: 31\r", out.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("    O O O", out.toString().split("\n")[20]);
    assertEquals("O O O O O O O", out.toString().split("\n")[21]);
    assertEquals("O _ _ O O O O", out.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O", out.toString().split("\n")[24]);
    assertEquals("    O O O\r", out.toString().split("\n")[25]);
    assertEquals("Score: 31\r", out.toString().split("\n")[26]);
  }

  @Test
  public void testGameOverLoss() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("4 2 4 4 4 5 4 3 4 7 4 5 2 4 4 4 5 4 3 4 7 4 5 4")).playGame();
    assertEquals("Game over!\r", out.toString().split("\n")[56]);
    assertEquals("    O O O", out.toString().split("\n")[57]);
    assertEquals("    O _ O", out.toString().split("\n")[58]);
    assertEquals("O O O O O O O", out.toString().split("\n")[59]);
    assertEquals("O _ O _ O _ _", out.toString().split("\n")[60]);
    assertEquals("O O O O O O O", out.toString().split("\n")[61]);
    assertEquals("    O _ O", out.toString().split("\n")[62]);
    assertEquals("    O _ O\r", out.toString().split("\n")[63]);
    assertEquals("Score: 26\r", out.toString().split("\n")[64]);

    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("4 2 4 4 2 3 4 3 5 3 3 3 7 3 5 3 2 5 2 3 4 5 4 3 7 5 7 3 6 "
                    + "5 4 5 4 5 2 5 3 7 3 5 4 7 4 5 5 7 5 5 5 4 5 6 3 5 5 5 5 5 5 7 4 3 6 3 6 "
                    + "3 6 5 6 6 6 4 5 1 5 3 3 3 3 5 2 5 4 5 1 3 3 3 3 2 3 4 3 1 5 1 1"
                    + " 5 1 3")).playGame();
    assertEquals("Game over!\r", out2.toString().split("\n")[208]);
    assertEquals("    O _ _", out2.toString().split("\n")[209]);
    assertEquals("  O _ _ _ O", out2.toString().split("\n")[210]);
    assertEquals("_ _ _ O _ _ _", out2.toString().split("\n")[211]);
    assertEquals("_ _ _ _ O _ _", out2.toString().split("\n")[212]);
    assertEquals("O _ O _ _ _ O", out2.toString().split("\n")[213]);
    assertEquals("  O _ O _ _", out2.toString().split("\n")[214]);
    assertEquals("    O _ _\r", out2.toString().split("\n")[215]);
    assertEquals("Score: 11\r", out2.toString().split("\n")[216]);

    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 3 1 1 3 1 3 3 4 4 2 2 1 1 3 1 4 1 2 1 5 4 3 2 2 1 4 3 5 2 "
                    + "3 2 2 2 4 2 5 3 3 1")).playGame();
    assertEquals("Game over!\r", out3.toString().split("\n")[66]);
    assertEquals("    _", out3.toString().split("\n")[67]);
    assertEquals("   _ _", out3.toString().split("\n")[68]);
    assertEquals("  O _ _", out3.toString().split("\n")[69]);
    assertEquals(" _ _ O _", out3.toString().split("\n")[70]);
    assertEquals("O _ _ _ O\r", out3.toString().split("\n")[71]);
    assertEquals("Score: 4\r", out3.toString().split("\n")[72]);
  }

  @Test
  public void testGameOverWin() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("2 4 4 4 3 2 3 4 1 3 3 3 1 5 1 3 3 4 3 2 3 1 3 3 3 5 1 5 3 7 3 5 "
                    + "4 3 2 3 1 3 3 3 4 1 4 3 4 3 2 3 4 5 2 5 1 5 3 5 4 7 4 5 4 5 2 5 6 3 4 3 5 1 "
                    + "5 3 5 3 3 3 2 3 4 3 4 3 4 5 5 5 3 5 2 5 4 5 5 7 5 5 5 4 5 6 7 5 5 5 4 5 6 5 "
                    + "7 3 7 5 7 5 5 5 5 6 5 4 6 4 4 4")).playGame();
    assertEquals("Game over!\r", out.toString().split("\n")[256]);
    assertEquals("    _ _ _", out.toString().split("\n")[257]);
    assertEquals("    _ _ _", out.toString().split("\n")[258]);
    assertEquals("_ _ _ _ _ _ _", out.toString().split("\n")[259]);
    assertEquals("_ _ _ O _ _ _", out.toString().split("\n")[260]);
    assertEquals("_ _ _ _ _ _ _", out.toString().split("\n")[261]);
    assertEquals("    _ _ _", out.toString().split("\n")[262]);
    assertEquals("    _ _ _\r", out.toString().split("\n")[263]);

    new MarbleSolitaireControllerImpl(board4,
            new MarbleSolitaireTextView(board4, out2),
            new StringReader("2 2 2 4 4 3 2 3 4 5 4 3 2 5 4 5 6 4 4 4 5 2 5 4 3 2 5 2 3 7 3 5 5 "
                    + "5 5 3 4 5 2 5 4 3 4 5 6 2 4 2 5 7 3 7 4 1 4 3 5 6 3 6 1 3 3 3 3 7 3 5 7 5"
                    + " 5 5 4 5 6 5 3 4 3 2 3 1 3 3 2 5 4 5 6 6 6 4 7 4 5 4 5 4 5 2 7 3 5 3 4 "
                    + "3 6 3 "
                    + "5 1 5 3 6 3 4 3 4 3 2 3 2 3 2 5 1 5 3 5 4 5 2 5 2 6 2 4 1 4 "
                    + "3 4")).playGame();
    assertEquals("Game over!\r", out2.toString().split("\n")[288]);
    assertEquals("    _ _ _", out2.toString().split("\n")[289]);
    assertEquals("  _ _ _ _ _", out2.toString().split("\n")[290]);
    assertEquals("_ _ _ O _ _ _", out2.toString().split("\n")[291]);
    assertEquals("_ _ _ _ _ _ _", out2.toString().split("\n")[292]);
    assertEquals("_ _ _ _ _ _ _", out2.toString().split("\n")[293]);
    assertEquals("  _ _ _ _ _", out2.toString().split("\n")[294]);
    assertEquals("    _ _ _\r", out2.toString().split("\n")[295]);
    assertEquals("Score: 1\r", out2.toString().split("\n")[296]);

    new MarbleSolitaireControllerImpl(board3,
            new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 1 1 1 3 3 3 1 5 5 3 3 2 2 4 4 5 3 3 3 5 1 5 3 5 4 5 2 5 2 3 2 "
                    + "4 4 2 2 4 1 2 1 1 1 3 1 3 1 3 3 3 3 1 1")).playGame();
    assertEquals("Game over!\r", out3.toString().split("\n")[84]);
    assertEquals("    O", out3.toString().split("\n")[85]);
    assertEquals("   _ _", out3.toString().split("\n")[86]);
    assertEquals("  _ _ _", out3.toString().split("\n")[87]);
    assertEquals(" _ _ _ _", out3.toString().split("\n")[88]);
    assertEquals("_ _ _ _ _\r", out3.toString().split("\n")[89]);
    assertEquals("Score: 1\r", out3.toString().split("\n")[90]);
  }

  @Test
  public void testMisInput() {
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("w 2 4 4 4 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("    O O O", out.toString().split("\n")[9]);
    assertEquals("    O _ O", out.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("    O O O", out.toString().split("\n")[14]);
    assertEquals("    O O O\r", out.toString().split("\n")[15]);
    assertEquals("Score: 31\r", out.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("    O _ O", out.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O", out.toString().split("\n")[24]);
    assertEquals("    O O O\r", out.toString().split("\n")[25]);
    assertEquals("Score: 31\r", out.toString().split("\n")[26]);
    out = new StringBuilder();
    board1 = new EnglishSolitaireModel();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("2 w 4 4 4 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("    O O O", out.toString().split("\n")[9]);
    assertEquals("    O _ O", out.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("    O O O", out.toString().split("\n")[14]);
    assertEquals("    O O O\r", out.toString().split("\n")[15]);
    assertEquals("Score: 31\r", out.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("    O _ O", out.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O", out.toString().split("\n")[24]);
    assertEquals("    O O O\r", out.toString().split("\n")[25]);
    assertEquals("Score: 31\r", out.toString().split("\n")[26]);
    out = new StringBuilder();
    board1 = new EnglishSolitaireModel();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("2 4 w 4 4 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("    O O O", out.toString().split("\n")[9]);
    assertEquals("    O _ O", out.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("    O O O", out.toString().split("\n")[14]);
    assertEquals("    O O O\r", out.toString().split("\n")[15]);
    assertEquals("Score: 31\r", out.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("    O _ O", out.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O", out.toString().split("\n")[24]);
    assertEquals("    O O O\r", out.toString().split("\n")[25]);
    assertEquals("Score: 31\r", out.toString().split("\n")[26]);
    out = new StringBuilder();
    board1 = new EnglishSolitaireModel();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("2 4 4 w 4 q")).playGame();
    assertEquals("Fix inputs.\r", out.toString().split("\n")[8]);
    assertEquals("    O O O", out.toString().split("\n")[9]);
    assertEquals("    O _ O", out.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out.toString().split("\n")[13]);
    assertEquals("    O O O", out.toString().split("\n")[14]);
    assertEquals("    O O O\r", out.toString().split("\n")[15]);
    assertEquals("Score: 31\r", out.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("    O _ O", out.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O", out.toString().split("\n")[24]);
    assertEquals("    O O O\r", out.toString().split("\n")[25]);
    assertEquals("Score: 31\r", out.toString().split("\n")[26]);
    out = new StringBuilder();
    board1 = new EnglishSolitaireModel();
    new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
            new StringReader("2 4 4 4 w q")).playGame();
    assertEquals("    O O O", out.toString().split("\n")[8]);
    assertEquals("    O _ O", out.toString().split("\n")[9]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[10]);
    assertEquals("O O O O O O O", out.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out.toString().split("\n")[12]);
    assertEquals("    O O O", out.toString().split("\n")[13]);
    assertEquals("    O O O\r", out.toString().split("\n")[14]);
    assertEquals("Score: 31\r", out.toString().split("\n")[15]);
    assertEquals("Fix inputs.\r", out.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out.toString().split("\n")[18]);
    assertEquals("    O O O", out.toString().split("\n")[19]);
    assertEquals("    O _ O", out.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out.toString().split("\n")[23]);
    assertEquals("    O O O", out.toString().split("\n")[24]);
    assertEquals("    O O O\r", out.toString().split("\n")[25]);
    assertEquals("Score: 31\r", out.toString().split("\n")[26]);

    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("w 2 4 4 4 q")).playGame();
    assertEquals("Fix inputs.\r", out2.toString().split("\n")[8]);
    assertEquals("    O O O", out2.toString().split("\n")[9]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[13]);
    assertEquals("  O O O O O", out2.toString().split("\n")[14]);
    assertEquals("    O O O\r", out2.toString().split("\n")[15]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[18]);
    assertEquals("    O O O", out2.toString().split("\n")[19]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[23]);
    assertEquals("  O O O O O", out2.toString().split("\n")[24]);
    assertEquals("    O O O\r", out2.toString().split("\n")[25]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[26]);
    out2 = new StringBuilder();
    board2 = new EuropeanSolitaireModel();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 w 4 4 4 q")).playGame();
    assertEquals("Fix inputs.\r", out2.toString().split("\n")[8]);
    assertEquals("    O O O", out2.toString().split("\n")[9]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[13]);
    assertEquals("  O O O O O", out2.toString().split("\n")[14]);
    assertEquals("    O O O\r", out2.toString().split("\n")[15]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[18]);
    assertEquals("    O O O", out2.toString().split("\n")[19]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[23]);
    assertEquals("  O O O O O", out2.toString().split("\n")[24]);
    assertEquals("    O O O\r", out2.toString().split("\n")[25]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[26]);
    out2 = new StringBuilder();
    board2 = new EuropeanSolitaireModel();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 4 w 4 4 q")).playGame();
    assertEquals("Fix inputs.\r", out2.toString().split("\n")[8]);
    assertEquals("    O O O", out2.toString().split("\n")[9]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[13]);
    assertEquals("  O O O O O", out2.toString().split("\n")[14]);
    assertEquals("    O O O\r", out2.toString().split("\n")[15]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[18]);
    assertEquals("    O O O", out2.toString().split("\n")[19]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[23]);
    assertEquals("  O O O O O", out2.toString().split("\n")[24]);
    assertEquals("    O O O\r", out2.toString().split("\n")[25]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[26]);
    out2 = new StringBuilder();
    board2 = new EuropeanSolitaireModel();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 4 4 w 4 q")).playGame();
    assertEquals("Fix inputs.\r", out2.toString().split("\n")[8]);
    assertEquals("    O O O", out2.toString().split("\n")[9]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[10]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[13]);
    assertEquals("  O O O O O", out2.toString().split("\n")[14]);
    assertEquals("    O O O\r", out2.toString().split("\n")[15]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[18]);
    assertEquals("    O O O", out2.toString().split("\n")[19]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[23]);
    assertEquals("  O O O O O", out2.toString().split("\n")[24]);
    assertEquals("    O O O\r", out2.toString().split("\n")[25]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[26]);
    out2 = new StringBuilder();
    board2 = new EuropeanSolitaireModel();
    new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out2),
            new StringReader("2 4 4 4 w q")).playGame();
    assertEquals("    O O O", out2.toString().split("\n")[8]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[9]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[10]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[11]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[12]);
    assertEquals("  O O O O O", out2.toString().split("\n")[13]);
    assertEquals("    O O O\r", out2.toString().split("\n")[14]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[15]);
    assertEquals("Fix inputs.\r", out2.toString().split("\n")[16]);
    assertEquals("Game quit!\r", out2.toString().split("\n")[17]);
    assertEquals("State of game when quit:\r", out2.toString().split("\n")[18]);
    assertEquals("    O O O", out2.toString().split("\n")[19]);
    assertEquals("  O O _ O O", out2.toString().split("\n")[20]);
    assertEquals("O O O _ O O O", out2.toString().split("\n")[21]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[22]);
    assertEquals("O O O O O O O", out2.toString().split("\n")[23]);
    assertEquals("  O O O O O", out2.toString().split("\n")[24]);
    assertEquals("    O O O\r", out2.toString().split("\n")[25]);
    assertEquals("Score: 35\r", out2.toString().split("\n")[26]);

    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 1 1 1 w q")).playGame();
    assertEquals("    O", out3.toString().split("\n")[6]);
    assertEquals("   _ O", out3.toString().split("\n")[7]);
    assertEquals("  _ O O", out3.toString().split("\n")[8]);
    assertEquals(" O O O O", out3.toString().split("\n")[9]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[10]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[11]);
    assertEquals("Fix inputs.\r", out3.toString().split("\n")[12]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[13]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[14]);
    assertEquals("    O", out3.toString().split("\n")[15]);
    assertEquals("   _ O", out3.toString().split("\n")[16]);
    assertEquals("  _ O O", out3.toString().split("\n")[17]);
    assertEquals(" O O O O", out3.toString().split("\n")[18]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[19]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[20]);
    out3 = new StringBuilder();
    board3 = new TriangleSolitaireModel();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 1 1 w 1 q")).playGame();
    assertEquals("Fix inputs.\r", out3.toString().split("\n")[6]);
    assertEquals("    O", out3.toString().split("\n")[7]);
    assertEquals("   _ O", out3.toString().split("\n")[8]);
    assertEquals("  _ O O", out3.toString().split("\n")[9]);
    assertEquals(" O O O O", out3.toString().split("\n")[10]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[11]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[12]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[13]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[14]);
    assertEquals("    O", out3.toString().split("\n")[15]);
    assertEquals("   _ O", out3.toString().split("\n")[16]);
    assertEquals("  _ O O", out3.toString().split("\n")[17]);
    assertEquals(" O O O O", out3.toString().split("\n")[18]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[19]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[20]);
    out3 = new StringBuilder();
    board3 = new TriangleSolitaireModel();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 1 w 1 1 q")).playGame();
    assertEquals("Fix inputs.\r", out3.toString().split("\n")[6]);
    assertEquals("    O", out3.toString().split("\n")[7]);
    assertEquals("   _ O", out3.toString().split("\n")[8]);
    assertEquals("  _ O O", out3.toString().split("\n")[9]);
    assertEquals(" O O O O", out3.toString().split("\n")[10]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[11]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[12]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[13]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[14]);
    assertEquals("    O", out3.toString().split("\n")[15]);
    assertEquals("   _ O", out3.toString().split("\n")[16]);
    assertEquals("  _ O O", out3.toString().split("\n")[17]);
    assertEquals(" O O O O", out3.toString().split("\n")[18]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[19]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[20]);
    out3 = new StringBuilder();
    board3 = new TriangleSolitaireModel();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("3 w 1 1 1 q")).playGame();
    assertEquals("Fix inputs.\r", out3.toString().split("\n")[6]);
    assertEquals("    O", out3.toString().split("\n")[7]);
    assertEquals("   _ O", out3.toString().split("\n")[8]);
    assertEquals("  _ O O", out3.toString().split("\n")[9]);
    assertEquals(" O O O O", out3.toString().split("\n")[10]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[11]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[12]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[13]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[14]);
    assertEquals("    O", out3.toString().split("\n")[15]);
    assertEquals("   _ O", out3.toString().split("\n")[16]);
    assertEquals("  _ O O", out3.toString().split("\n")[17]);
    assertEquals(" O O O O", out3.toString().split("\n")[18]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[19]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[20]);
    out3 = new StringBuilder();
    board3 = new TriangleSolitaireModel();
    new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out3),
            new StringReader("w 3 1 1 1 q")).playGame();
    assertEquals("Fix inputs.\r", out3.toString().split("\n")[6]);
    assertEquals("    O", out3.toString().split("\n")[7]);
    assertEquals("   _ O", out3.toString().split("\n")[8]);
    assertEquals("  _ O O", out3.toString().split("\n")[9]);
    assertEquals(" O O O O", out3.toString().split("\n")[10]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[11]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[12]);
    assertEquals("Game quit!\r", out3.toString().split("\n")[13]);
    assertEquals("State of game when quit:\r", out3.toString().split("\n")[14]);
    assertEquals("    O", out3.toString().split("\n")[15]);
    assertEquals("   _ O", out3.toString().split("\n")[16]);
    assertEquals("  _ O O", out3.toString().split("\n")[17]);
    assertEquals(" O O O O", out3.toString().split("\n")[18]);
    assertEquals("O O O O O\r", out3.toString().split("\n")[19]);
    assertEquals("Score: 13\r", out3.toString().split("\n")[20]);
  }

  @Test
  public void testNoInputs() {
    try {
      new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
              new StringReader("")).playGame();
    } catch (IllegalStateException e) {
      assertEquals("No inputs", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(board1, new MarbleSolitaireTextView(board1, out),
              new StringReader("6 4 4 4")).playGame();
      //There are inputs for one move but after the move the inputs end without the game being quit
    } catch (IllegalStateException e) {
      assertEquals("No inputs", e.getMessage());
    }
    try {
      new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out),
              new StringReader("")).playGame();
    } catch (IllegalStateException e) {
      assertEquals("No inputs", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(board2, new MarbleSolitaireTextView(board2, out),
              new StringReader("6 4 4 4")).playGame();
      //There are inputs for one move but after the move the inputs end without the game being quit
    } catch (IllegalStateException e) {
      assertEquals("No inputs", e.getMessage());
    }
    try {
      new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out),
              new StringReader("")).playGame();
    } catch (IllegalStateException e) {
      assertEquals("No inputs", e.getMessage());
    }

    try {
      new MarbleSolitaireControllerImpl(board3, new TriangleSolitaireTextView(board3, out),
              new StringReader("6 4 4 4")).playGame();
      //There are inputs for one move but after the move the inputs end without the game being quit
    } catch (IllegalStateException e) {
      assertEquals("No inputs", e.getMessage());
    }
  }

}
