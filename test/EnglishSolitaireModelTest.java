import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * This is the EnglishSolitaireModelTest class to test the creation and interactions
 * of the pieces on the game board.
 * Tests the {@code EnglishSolitaireModelTest} class.
 */
public class EnglishSolitaireModelTest {

  MarbleSolitaireModel game1;
  MarbleSolitaireModel game2;
  MarbleSolitaireModel game3;
  MarbleSolitaireModel game4;
  MarbleSolitaireModel game5;


  @Before
  public void init() {
    game1 = new EnglishSolitaireModel();
    game2 = new EnglishSolitaireModel(3);
    game3 = new EnglishSolitaireModel(3, 3, 3);
    game4 = new EnglishSolitaireModel(5, 6, 6);
    game5 = new EnglishSolitaireModel(7, 9, 9);
  }

  @Test
  public void testValidConInit() {
    assertEquals(7, game1.getBoardSize());
    game1.move(1, 3, 3, 3);
  }

  @Test
  public void testValidConstructors() throws IllegalArgumentException {
    MarbleSolitaireModel test1 = new EnglishSolitaireModel(3);
    MarbleSolitaireModel test2 = new EnglishSolitaireModel(3, 3, 3);
    MarbleSolitaireModel test3 = new EnglishSolitaireModel(3, 3);

    try {
      MarbleSolitaireModel test4 = new EnglishSolitaireModel(2);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test5 = new EnglishSolitaireModel(6, 6);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test6 = new EnglishSolitaireModel(4, 3, 3);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test7 = new EnglishSolitaireModel(5, 1, 1);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }


  }


  @Test
  public void move() {
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 3));
    game1.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 2));
    game1.move(1, 2, 3, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(2, 2));


    try {
      game1.move(2, 1, 2, 2);
      fail("This move is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals("This is not a legal move!", e.getMessage());
    }
    try {
      game1.move(2, 1, 3, 6);
      fail("This move is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals("This is not a legal move!", e.getMessage());
    }
    try {
      game1.move(6, 6, 2, 2);
      fail("This move is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals("This is not a legal move!", e.getMessage());
    }
    try {
      game1.move(2, 1, 2, 2);
      fail("This move is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals("This is not a legal move!", e.getMessage());
    }
    try {
      game1.move(0, 2, 2, 2);
      fail("This move is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals("This is not a legal move!", e.getMessage());
    }
    try {
      game1.move(4, 2, 1, 2);
      fail("This move is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals("This is not a legal move!", e.getMessage());
    }
    try {
      game1.move(0, 4, 2, 2);
      fail("This move is invalid");
    } catch (IllegalArgumentException e) {
      assertEquals("This is not a legal move!", e.getMessage());
    }


  }

  @Test
  public void isGameOver() {
    assertFalse(this.game1.isGameOver());
    this.game1.move(3, 1, 3, 3);
    this.game1.move(3, 4, 3, 2);
    this.game1.move(3, 6, 3, 4);
    this.game1.move(1, 3, 3, 3);
    this.game1.move(4, 3, 2, 3);
    this.game1.move(6, 3, 4, 3);
    assertTrue(this.game1.isGameOver());

  }

  @Test
  public void getBoardSize() {
    assertEquals(7, this.game1.getBoardSize());
    assertEquals(13, this.game4.getBoardSize());
    assertEquals(19, this.game5.getBoardSize());
  }

  @Test
  public void getSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(0, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game1.getSlotAt(0, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game1.getSlotAt(0, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(2, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(4, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game1.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(0, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game4.getSlotAt(0, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game4.getSlotAt(0, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game4.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(8, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(9, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game4.getSlotAt(9, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game4.getSlotAt(11, 11));
  }

  @Test
  public void getScore() {
    assertEquals(32, this.game1.getScore());
    this.game1.move(3, 1, 3, 3);
    assertEquals(31, this.game1.getScore());
    this.game1.move(3, 4, 3, 2);
    assertEquals(30, this.game1.getScore());
    this.game1.move(3, 6, 3, 4);
    assertEquals(29, this.game1.getScore());
    this.game1.move(1, 3, 3, 3);
    assertEquals(28, this.game1.getScore());
    this.game1.move(4, 3, 2, 3);
    assertEquals(27, this.game1.getScore());
    this.game1.move(6, 3, 4, 3);
    assertEquals(26, this.game1.getScore());
  }
}