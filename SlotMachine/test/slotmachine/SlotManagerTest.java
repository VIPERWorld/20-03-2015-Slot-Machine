/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Asma
 */
public class SlotManagerTest {

    SlotManager sm;

    @Before
    public void setUp() {
        try {
            sm = new SlotManager();
        } catch (IOException ex) {
            Logger.getLogger(SlotManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        sm = null;
    }

    @Test
    public void testSpin() {
        sm.spin();
    }

    @Test
    public void testTwoInARow() {
        sm.getSlot1().setSpecificImage(0);
        sm.getSlot2().setSpecificImage(0);
        sm.getSlot3().setSpecificImage(3);
        assertEquals("Two in a row!", sm.checkCombos());
    }

    @Test
    public void testThreeInARow() {
        sm.getSlot1().setSpecificImage(0);
        sm.getSlot2().setSpecificImage(0);
        sm.getSlot3().setSpecificImage(0);
        assertEquals("Three in a row!", sm.checkCombos());
    }

}
