import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * TriangleSolitaireModelTest test class used to test the initialization and interactions
 * the game board of a triangle version of peg solitaire.
 */
public class TriangleSolitaireModelTest {
  MarbleSolitaireModel game1;
  MarbleSolitaireModel game2;
  MarbleSolitaireModel game3;
  MarbleSolitaireModel game4;
  MarbleSolitaireModel game5;


  @Before
  public void init() {
    game1 = new TriangleSolitaireModel();
    game2 = new TriangleSolitaireModel(5);
    game3 = new TriangleSolitaireModel(5, 0, 0);
    game4 = new TriangleSolitaireModel(7, 0, 0);
    game5 = new TriangleSolitaireModel(4, 0, 0);
  }

  @Test
  public void testValidConstructors() throws IllegalArgumentException {
    MarbleSolitaireModel test1 = new TriangleSolitaireModel(5);
    MarbleSolitaireModel test2 = new TriangleSolitaireModel(5, 0, 0);
    MarbleSolitaireModel test3 = new TriangleSolitaireModel(0, 0);
    MarbleSolitaireModel test10 = new TriangleSolitaireModel();

    try {
      MarbleSolitaireModel test4 = new TriangleSolitaireModel(5, 6, 7);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test4 = new TriangleSolitaireModel(-1, 6, 7);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test4 = new TriangleSolitaireModel(0, 6, 7);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
    try {
      MarbleSolitaireModel test4 = new TriangleSolitaireModel(5, 6, 6);
      fail("Invalid initialization");
    } catch (IllegalArgumentException e) {
      // correctly expecting an IllegalArgumentException
    }
  }

  @Test
  public void move() {
    game1.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(1, 0));
    game1.move(4, 2, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(3, 1));
    game1.move(4, 0, 4, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(4, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(4, 1));
    game1.move(4, 3, 4, 1);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(4, 2));
    game1.move(2, 2, 4, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(4, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(3, 2));
    game1.move(4, 1, 4, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(4, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(4, 2));

  }

  @Test
  public void isGameOver() {
    assertFalse(this.game1.isGameOver());
    this.game1.move(2, 0, 0, 0);
    this.game1.move(2, 2, 2, 0);
    this.game1.move(4, 4, 2, 2);
    this.game1.move(1, 1, 3, 3);
    this.game1.move(4, 2, 2, 2);
    this.game1.move(4, 0, 4, 2);
    this.game1.move(4, 3, 4, 1);
    this.game1.move(4, 1, 2, 1);
    this.game1.move(3, 3, 1, 1);
    this.game1.move(3, 0, 1, 0);
    this.game1.move(0, 0, 2, 0);
    this.game1.move(2, 0, 2, 2);
    this.game1.move(2, 2, 0, 0);
    assertTrue(this.game1.isGameOver());

  }

  @Test
  public void getBoardSize() {
    assertEquals(game1.getBoardSize(), 5);
  }

  @Test
  public void getScoreTest() {
    assertEquals(14, game1.getScore());
    this.game1.move(2, 0, 0, 0);
    assertEquals(13, game1.getScore());
    this.game1.move(2, 2, 2, 0);
    assertEquals(12, game1.getScore());

  }
}