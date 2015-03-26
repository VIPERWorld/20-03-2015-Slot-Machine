/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import GUI.SoundNames;
import Starter.SlotMachine;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Asma
 */
public class SlotManagerTest {

    SlotMachine sm;

    @Before
    public void setUp() {
        try {
            sm = new SlotMachine();
        } catch (IOException ex) {
            Logger.getLogger(SlotManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Exception caught");
        }
    }

    @After
    public void tearDown() {
        sm = null;
    }

    @Test
    public void testSpin() {
        sm.getSlotManager().spin();
    }

    @Test
    public void testTwoInARow() {
        sm.getSlotManager().getSlot1().setSpecificImage(0);
        sm.getSlotManager().getSlot2().setSpecificImage(0);
        sm.getSlotManager().getSlot3().setSpecificImage(3);
    }

    @Test
    public void testThreeInARow() {
        sm.getSlotManager().getSlot1().setSpecificImage(0);
        sm.getSlotManager().getSlot2().setSpecificImage(0);
        sm.getSlotManager().getSlot3().setSpecificImage(0);
    }
    
    @Test
    public void testAudio() throws InterruptedException{
        sm.getSoundPlayer().playSound(SoundNames.THREE_IN_A_ROW);
        //Thread.sleep(4000);
        sm.getSoundPlayer().playSound(SoundNames.TWO_IN_A_ROW);
        //Thread.sleep(2000);
    }
    
    @Test
    public void testEquals(){
        sm.getSlotManager().getSlot1().setSpecificImage(3);
        sm.getSlotManager().getSlot2().setSpecificImage(3);
        sm.getSlotManager().getSlot3().setSpecificImage(2);
        
        assertEquals("Two in a row!", sm.getSlotManager().checkCombos());
        sm.getSlotManager().getSlot3().setSpecificImage(3);
        assertEquals("Three in a row!", sm.getSlotManager().checkCombos());
    }
    
    @Test
    public void testHoldEquals(){
        sm.getSlotManager().getSlot1().setSpecificImage(0);
        sm.getSlotManager().getSlot2().setSpecificImage(0);
        sm.getSlotManager().getSlot3().setSpecificImage(2);
        
        assertEquals("None in a row!", sm.getSlotManager().checkCombos());
        sm.getSlotManager().getSlot1().setHold(true);
        sm.getSlotManager().getSlot2().setHold(true);
        assertEquals("None in a row!", sm.getSlotManager().checkCombos());
        sm.getSlotManager().getSlot3().setSpecificImage(1);
        assertEquals("None in a row!", sm.getSlotManager().checkCombos());
        sm.getSlotManager().getSlot1().setHold(false);
        sm.getSlotManager().getSlot2().setHold(false);
        assertEquals("None in a row!", sm.getSlotManager().checkCombos());
        
        sm.getSlotManager().getSlot1().setSpecificImage(1);
        sm.getSlotManager().getSlot2().setSpecificImage(1);
        sm.getSlotManager().getSlot3().setSpecificImage(2);
        assertEquals("None in a row!", sm.getSlotManager().checkCombos());
        sm.getSlotManager().getSlot1().setHold(true);
        sm.getSlotManager().getSlot2().setHold(true);
        assertEquals("None in a row!", sm.getSlotManager().checkCombos());
        sm.getSlotManager().getSlot3().setSpecificImage(1);
        assertEquals("Three in a row!", sm.getSlotManager().checkCombos());
        
    }
    
    

}
