/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import GUI.SoundPlayer;
import GUI.soundNames;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Asma
 */
public class SlotManagerTest {

    SlotManager sm;
    SoundPlayer sp;

    @Before
    public void setUp() {
        sp = new SoundPlayer();
        try {
            sm = new SlotManager();
        } catch (IOException ex) {
            Logger.getLogger(SlotManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        sm = null;
        sp = null;
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
    }

    @Test
    public void testThreeInARow() {
        sm.getSlot1().setSpecificImage(0);
        sm.getSlot2().setSpecificImage(0);
        sm.getSlot3().setSpecificImage(0);
    }
    
    @Test
    public void testAudio() throws InterruptedException{
        //sp.playSound(soundNames.TWO_IN_A_ROW);
        try {
        sp.playSound(soundNames.TWO_IN_A_ROW); 
        Thread.sleep(4000);
            
        } catch (NullPointerException ex) {
            System.out.println(soundNames.THREE_IN_A_ROW.getPath());
            Logger.getLogger(SoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Test
    public void testEquals(){
        sm.getSlot1().setSpecificImage(1);
        sm.getSlot2().setSpecificImage(1);
        sm.getSlot3().setSpecificImage(3);
        sm.getSlot1().setHold(true);
        
        assertFalse(sm.checkCombos());
        sm.getSlot1().setHold(false);
        assertTrue(sm.checkCombos());
    }

}
