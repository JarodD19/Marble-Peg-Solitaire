import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This is the TriangleSolitaireTextViewTest class used to test the rendering of the
 * game board as a String.
 * Tests the {@code TriangleSolitaireTextViewTest} class.
 */
public class TriangleSolitaireTextViewTest {

  TriangleSolitaireTextView game1;

  TriangleSolitaireTextView game2;

  TriangleSolitaireTextView game3;

  TriangleSolitaireTextView game4;

  TriangleSolitaireModel board1;

  TriangleSolitaireModel board2;

  TriangleSolitaireModel board3;

  @Before
  public void init() {
    board1 = new TriangleSolitaireModel();
    board2 = new TriangleSolitaireModel();
    board3 = new TriangleSolitaireModel(5);
    game1 = new TriangleSolitaireTextView(board1);
    game2 = new TriangleSolitaireTextView(new TriangleSolitaireModel(5));
    game3 = new TriangleSolitaireTextView(new TriangleSolitaireModel(5, 0, 0));
    game4 = new TriangleSolitaireTextView(new TriangleSolitaireModel(7, 2, 2));
  }

  @Test
  public void testValidInit() {
    TriangleSolitaireTextView test1 = new TriangleSolitaireTextView(new TriangleSolitaireModel());
    TriangleSolitaireTextView test2 = new TriangleSolitaireTextView(
            new TriangleSolitaireModel(3));
    TriangleSolitaireTextView test3
            = new TriangleSolitaireTextView(new TriangleSolitaireModel(0, 0));
    TriangleSolitaireTextView test11
            = new TriangleSolitaireTextView(new TriangleSolitaireModel(2));
    TriangleSolitaireTextView test4
            = new TriangleSolitaireTextView(new TriangleSolitaireModel(5, 0, 0));
    TriangleSolitaireTextView test10
            = new TriangleSolitaireTextView(new TriangleSolitaireModel(), new StringBuilder());

    try {
      TriangleSolitaireTextView test5 = new TriangleSolitaireTextView(
              new TriangleSolitaireModel(-1));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      TriangleSolitaireTextView test5
              = new TriangleSolitaireTextView(new TriangleSolitaireModel(7, 7));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      TriangleSolitaireTextView test5
              = new TriangleSolitaireTextView(new TriangleSolitaireModel(3, 7, 7));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      TriangleSolitaireTextView test5 = new TriangleSolitaireTextView(null);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      TriangleSolitaireTextView test5 = new TriangleSolitaireTextView(null,
              new StringBuilder());
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      TriangleSolitaireTextView test5 = new TriangleSolitaireTextView(board1, null);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      TriangleSolitaireTextView test5
              = new TriangleSolitaireTextView(new TriangleSolitaireModel(0, 3, 3));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      TriangleSolitaireTextView test5 = new TriangleSolitaireTextView(
              new TriangleSolitaireModel(0));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
  }

  @Test
  public void testToString() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", game1.toString());
    board1.move(2, 0, 0, 0);
    assertEquals("    O\n" +
            "   _ O\n" +
            "  _ O O\n" +
            " O O O O\n" +
            "O O O O O", game1.toString());
    assertEquals("      O\n" +
            "     O O\n" +
            "    O O _\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", game4.toString());
  }

  @Test
  public void testRenderBoard() {
    try {
      new TriangleSolitaireTextView(board1, new MockAppendable()).renderBoard();
      fail("Fails to renderBoard");
    } catch (IOException e) {
      // Successfully catches IOException
    }
  }

  @Test
  public void testRenderMessage() {
    try {
      new TriangleSolitaireTextView(board1, new MockAppendable()).renderMessage("Testing IO");
      fail("Fails to renderMessage");
    } catch (IOException e) {
      // Successfully catches IOException
    }
  }


}