package environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

import environment.Cell;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import org.junit.Test;

/**
 * The test cases for the Cell class
 */
public class TestCell {
  /**
   * At initialization, the Cell should be empty and not contain a
   * LifeForm.
   */
  @Test
  public void testInitialization() {
    Cell cell = new Cell();
    assertNull(cell.getLifeForm());
  }

  /**
   * Checks to see if we change the LifeForm held by the Cell that
   * getLifeForm properly responds to this change.
   */
  @Test
  public void testAddLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    LifeForm fred = new MockLifeForm("Fred", 40);
    Cell cell = new Cell();
    // The cell is empty so this should work.
    boolean success = cell.addLifeForm(bob);
    assertTrue(success);
    assertEquals(bob, cell.getLifeForm());
    // The cell is not empty so this should fail.
    success = cell.addLifeForm(fred);
    assertFalse(success);
    assertEquals(bob, cell.getLifeForm());
  }

  /**
   * Checks to see if the LifeForm can properly be removed from a Cell
   */
  @Test
  public void testRemoveLifeForm() {
    LifeForm bob = new MockLifeForm("Bob", 40);
    Cell cell = new Cell();
    assertTrue(cell.addLifeForm(bob));
    cell.removeLifeForm();
    assertNull(cell.getLifeForm());
  }


}
