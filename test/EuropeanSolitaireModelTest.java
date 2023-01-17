import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * This is the EuropeanSolitaireModelTest class to test the creation and interactions
 * of the pieces on the game board.
 * Tests the {@code EuropeanSolitaireModelTest} class.
 */
public class EuropeanSolitaireModelTest {

  MarbleSolitaireModel game1;
  MarbleSolitaireModel game2;
  MarbleSolitaireModel game3;
  MarbleSolitaireModel game4;
  MarbleSolitaireModel game5;

  MarbleSolitaireModel game6;

  MarbleSolitaireModel game7;


  @Before
  public void init() {
    game1 = new EuropeanSolitaireModel();
    game2 = new EuropeanSolitaireModel(3);
    game3 = new EuropeanSolitaireModel(3, 3, 3);
    game4 = new EuropeanSolitaireModel(5, 6, 6);
    game5 = new EuropeanSolitaireModel(7, 9, 9);
    game6 = new EuropeanSolitaireModel(9);
    game7 = new EuropeanSolitaireModel(3, 0, 2);
  }

  @Test
  public void testValidConInit() {
    assertEquals(7, game1.getBoardSize());
    game1.move(1, 3, 3, 3);
  }

  @Test
  public void testValidConstructors() throws IllegalArgumentException {
    MarbleSolitaireModel test1 = new EuropeanSolitaireModel(3);
    MarbleSolitaireModel test2 = new EuropeanSolitaireModel(3, 3, 3);
    MarbleSolitaireModel test3 = new EuropeanSolitaireModel(3, 3);
    MarbleSolitaireModel test10 = new EuropeanSolitaireModel(3, 1, 1);

    MarbleSolitaireModel test11 = new EuropeanSolitaireModel(5);

    try {
      MarbleSolitaireModel test4 = new EuropeanSolitaireModel(2);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test5 = new EuropeanSolitaireModel(6, 6);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test6 = new EuropeanSolitaireModel(4, 3, 3);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test7 = new EuropeanSolitaireModel(5, 1, 1);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }


  }


  @Test
  public void move() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 3));
    game1.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 2));
    game1.move(1, 2, 3, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(1, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(2, 2));
    game2.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game2.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game2.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game2.getSlotAt(3, 2));
    game3.move(5, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game3.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game3.getSlotAt(4, 3));


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
    assertFalse(this.game7.isGameOver());
    game7.move(2, 2, 0, 2);
    game7.move(2, 0, 2, 2);
    game7.move(1, 4, 1, 2);
    game7.move(3, 4, 1, 4);
    game7.move(3, 2, 3, 4);
    game7.move(2, 3, 2, 1);
    game7.move(5, 3, 3, 3);
    game7.move(3, 0, 3, 2);
    game7.move(5, 1, 3, 1);
    game7.move(4, 5, 4, 3);
    game7.move(5, 5, 5, 3);
    game7.move(0, 4, 2, 4);
    game7.move(2, 1, 4, 1);
    game7.move(2, 4, 4, 4);
    game7.move(5, 2, 5, 4);
    game7.move(3, 6, 3, 4);
    game7.move(1, 1, 1, 3);
    game7.move(2, 6, 2, 4);
    game7.move(0, 3, 2, 3);
    game7.move(3, 2, 5, 2);
    game7.move(3, 4, 3, 2);
    game7.move(6, 2, 4, 2);
    game7.move(3, 2, 5, 2);
    game7.move(4, 0, 4, 2);
    game7.move(4, 3, 4, 1);
    game7.move(6, 4, 6, 2);
    game7.move(6, 2, 4, 2);
    game7.move(4, 1, 4, 3);
    game7.move(4, 3, 4, 5);
    game7.move(4, 6, 4, 4);
    game7.move(5, 4, 3, 4);
    game7.move(3, 4, 1, 4);
    game7.move(1, 5, 1, 3);
    game7.move(2, 3, 0, 3);
    game7.move(0, 2, 0, 4);
    assertTrue(this.game7.isGameOver());
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
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game1.getSlotAt(5, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(0, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(0, 8));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game4.getSlotAt(0, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game4.getSlotAt(0, 9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, game4.getSlotAt(6, 6));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(8, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(9, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, game4.getSlotAt(9, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, game4.getSlotAt(11, 11));

  }

  @Test
  public void getScore() {
    assertEquals(36, game1.getScore());
    game1.move(3, 1, 3, 3);
    assertEquals(35, game1.getScore());
    game1.move(3, 4, 3, 2);
    assertEquals(34, game1.getScore());
    assertEquals(276, game5.getScore());
    assertEquals(480, game6.getScore());

  }
}