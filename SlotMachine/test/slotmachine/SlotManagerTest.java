/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import Slotmachine.SlotManager;
import GUI.SlotGUI;
import GUI.Sounds.SoundNames;
import GUI.Sounds.SoundPlayer;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Asma
 */
public class SlotManagerTest {

    SlotManager sm;
    SoundPlayer sp;
    SlotGUI gui;

    @Before
    public void setUp() throws LineUnavailableException {
        try {
            sp = new SoundPlayer(sm);
            sm = new SlotManager();
            gui = new SlotGUI(sm);
            sm.setGui(gui);
            sm.addObserver(gui);
        } catch (IOException ex) {
            Logger.getLogger(SlotManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Exception caught");
        }
    }

    @After
    public void tearDown() {
        sm = null;
        sp = null;
        gui = null;

    }

    @Test
    public void testSpin() {
        sm.spin();
    }

    @Test
    public void testTwoInARow() {
        sm.getSlot1().setSpecificImage(3);
        sm.getSlot2().setSpecificImage(3);
        sm.getSlot3().setSpecificImage(2);
        assertEquals("Two in a row!", sm.checkCombos());
    }

    @Test
    public void testThreeInARow() {
        sm.getSlot1().setSpecificImage(1);
        sm.getSlot2().setSpecificImage(1);
        sm.getSlot3().setSpecificImage(1);
        assertEquals("Three in a row!", sm.checkCombos());
    }

    @Test
    public void testAudio() throws InterruptedException {
        //sp.playSound(SoundNames.THREE_IN_A_ROW);
        //Thread.sleep(4000);
        //sp.playSound(SoundNames.TWO_IN_A_ROW);
        //Thread.sleep(2000);
    }

    @Test
    public void testEquals() {
        sm.getSlot1().setSpecificImage(3);
        sm.getSlot2().setSpecificImage(3);
        sm.getSlot3().setSpecificImage(2);

        assertTrue(sm.getSlot1().equals(sm.getSlot2()));
        assertFalse(sm.getSlot1().equals(sm.getSlot3()));
        assertFalse(sm.getSlot2().equals(sm.getSlot3()));
        sm.getSlot3().setSpecificImage(3);
        assertTrue(sm.getSlot1().equals(sm.getSlot2()));
        assertTrue(sm.getSlot1().equals(sm.getSlot3()));
        assertFalse(!sm.getSlot1().equals(sm.getSlot3()));
    }

    @Test
    public void testCombos() {
        sm.getSlot1().setSpecificImage(0);
        sm.getSlot2().setSpecificImage(0);
        sm.getSlot3().setSpecificImage(2);

        assertEquals("None in a row!", sm.checkCombos());
        sm.getSlot1().setHold(true);
        sm.getSlot2().setHold(true);
        assertEquals("None in a row!", sm.checkCombos());
        sm.getSlot3().setSpecificImage(1);
        assertEquals("None in a row!", sm.checkCombos());
        sm.getSlot1().setHold(false);
        sm.getSlot2().setHold(false);
        assertEquals("None in a row!", sm.checkCombos());

        sm.getSlot1().setSpecificImage(1);
        sm.getSlot2().setSpecificImage(1);
        sm.getSlot3().setSpecificImage(2);
        assertEquals("None in a row!", sm.checkCombos());
        sm.getSlot1().setHold(true);
        sm.getSlot2().setHold(true);
        assertEquals("None in a row!", sm.checkCombos());
        sm.getSlot3().setSpecificImage(1);
        assertEquals("Three in a row!", sm.checkCombos());

        resetSlots();
        assertEquals("Two in a row!", sm.checkCombos());
        sm.getSlot1().setHold(true);
        sm.getSlot2().setHold(true);
        assertEquals("None in a row!", sm.checkCombos());
        sm.getSlot3().setSpecificImage(3);
        assertEquals("Three in a row!", sm.checkCombos());

        resetSlots();
        sm.getSlot1().setHold(true);
        assertEquals("Two in a row!", sm.checkCombos());
        assertTrue(sm.getSlot1().equals(sm.getSlot2()));
        assertTrue(sm.getSlot1().equals(sm.getSlot2()));
        sm.getSlot2().setHold(true);
        assertEquals("None in a row!", sm.checkCombos());
        sm.getSlot3().setSpecificImage(3);
        assertEquals("Three in a row!", sm.checkCombos());
    }

    private void resetSlots() {
        sm.getSlot1().setHold(false);
        sm.getSlot2().setHold(false);
        sm.getSlot3().setHold(false);
        sm.getSlot1().setSpecificImage(3);
        sm.getSlot2().setSpecificImage(3);
        sm.getSlot3().setSpecificImage(2);
    }

}
