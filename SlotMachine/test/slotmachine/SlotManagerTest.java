/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
        try {
            sm.getSlot1().setIcon(ImageIO.read(getClass().getResource("/GUI/Images/Banana.png")));
            sm.getSlot2().setIcon(ImageIO.read(getClass().getResource("/GUI/Images/Banana.png")));
            sm.getSlot3().setIcon(ImageIO.read(getClass().getResource("/GUI/Images/Cherry.png")));
        } catch (IOException ex) {
            Logger.getLogger(SlotManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals("Two in a row!", sm.checkCombos());
    }

    @Test
    public void testThreeInARow() {
        try {
            sm.getSlot1().setIcon(ImageIO.read(getClass().getResource("/GUI/Images/Banana.png")));
            sm.getSlot2().setIcon(ImageIO.read(getClass().getResource("/GUI/Images/Banana.png")));
            sm.getSlot3().setIcon(ImageIO.read(getClass().getResource("/GUI/Images/Banana.png")));
        } catch (IOException ex) {
            Logger.getLogger(SlotManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals("Three in a row!", sm.checkCombos());
    }

}
