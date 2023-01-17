import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This is the MarbleSolitaireTextViewTest class used to test the rendering of the
 * game board as a String.
 * Tests the {@code MarbleSolitaireTextView} class.
 */
public class MarbleSolitaireTextViewTest {
  MarbleSolitaireTextView game1;
  MarbleSolitaireTextView game2;
  MarbleSolitaireTextView game3;
  MarbleSolitaireTextView game4;
  MarbleSolitaireTextView game5;
  MarbleSolitaireTextView game6;
  MarbleSolitaireTextView game7;
  MarbleSolitaireTextView game8;
  MarbleSolitaireTextView game9;

  MarbleSolitaireTextView game10;

  MarbleSolitaireTextView game11;

  MarbleSolitaireTextView game12;

  MarbleSolitaireTextView game13;

  MarbleSolitaireTextView game14;

  MarbleSolitaireTextView game15;

  MarbleSolitaireTextView game16;


  MarbleSolitaireModel board1;
  MarbleSolitaireModel board2;
  MarbleSolitaireModel board3;


  @Before
  public void init() {
    board1 = new EnglishSolitaireModel();
    board2 = new EnglishSolitaireModel();
    board3 = new EnglishSolitaireModel(3);
    game1 = new MarbleSolitaireTextView(board1);
    game2 = new MarbleSolitaireTextView(new EnglishSolitaireModel(3));
    game3 = new MarbleSolitaireTextView(new EnglishSolitaireModel(3, 3, 3));
    game4 = new MarbleSolitaireTextView(new EnglishSolitaireModel(5, 6, 6));
    game5 = new MarbleSolitaireTextView(new EnglishSolitaireModel(7, 9, 9));
    game6 = new MarbleSolitaireTextView(new EnglishSolitaireModel(3, 0, 2));
    game7 = new MarbleSolitaireTextView(new EnglishSolitaireModel(0, 2));
    game8 = new MarbleSolitaireTextView(board2);
    game9 = new MarbleSolitaireTextView(board3);
    game10 = new MarbleSolitaireTextView(new EuropeanSolitaireModel());
    game11 = new MarbleSolitaireTextView(new EuropeanSolitaireModel(5));
    game12 = new MarbleSolitaireTextView(new EuropeanSolitaireModel(3, 3, 3));


  }

  @Test
  public void testValidInit() {
    MarbleSolitaireTextView test1 = new MarbleSolitaireTextView(new EnglishSolitaireModel());
    MarbleSolitaireTextView test2 = new MarbleSolitaireTextView(new EnglishSolitaireModel(3));
    MarbleSolitaireTextView test3
            = new MarbleSolitaireTextView(new EnglishSolitaireModel(3, 3));
    MarbleSolitaireTextView test4
            = new MarbleSolitaireTextView(new EnglishSolitaireModel(3, 3, 3));
    MarbleSolitaireTextView test10
            = new MarbleSolitaireTextView(new EnglishSolitaireModel(), new StringBuilder());

    try {
      MarbleSolitaireTextView test5 = new MarbleSolitaireTextView(new EnglishSolitaireModel(2));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireTextView test5
              = new MarbleSolitaireTextView(new EnglishSolitaireModel(7, 7));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireTextView test5
              = new MarbleSolitaireTextView(new EnglishSolitaireModel(3, 7, 7));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireTextView test5 = new MarbleSolitaireTextView(null);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireTextView test5 = new MarbleSolitaireTextView(null, new StringBuilder());
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireTextView test5 = new MarbleSolitaireTextView(board1, null);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireTextView test5
              = new MarbleSolitaireTextView(new EnglishSolitaireModel(0, 3, 3));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireTextView test5 = new MarbleSolitaireTextView(new EnglishSolitaireModel(0));
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
  }

  @Test
  public void testToString() {
    assertEquals("    O O O\n"
            + "    O O O\n"
            + "O O O O O O O\n"
            + "O O O _ O O O\n"
            + "O O O O O O O\n"
            + "    O O O\n"
            + "    O O O", game1.toString());
    board3.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", game9.toString());

    assertEquals("    _ O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", game6.toString());
    assertEquals("    _ O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", game7.toString());


    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", game4.toString());
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", game5.toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game10.toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", game11.toString());


  }

  @Test
  public void testRenderBoard() {
    try {
      new MarbleSolitaireTextView(board1, new MockAppendable()).renderBoard();
      fail("Fails to renderBoard");
    } catch (IOException e) {
      // Successfully catches IOException
    }
  }

  @Test
  public void testRenderMessage() {
    try {
      new MarbleSolitaireTextView(board1, new MockAppendable()).renderMessage("Testing IO");
      fail("Fails to renderMessage");
    } catch (IOException e) {
      // Successfully catches IOException
    }
  }
}