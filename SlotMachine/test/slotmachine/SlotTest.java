/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asma
 */
public class SlotTest {

    Slot s1;
    Slot s2;
    Slot s3;
    SlotManager sm;

    @Before
    public void setUp() {
        try {
            sm = new SlotManager();
        } catch (IOException ex) {
            Logger.getLogger(SlotTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            s1 = new Slot(ImageIO.read(new File("Banana.png")), s1);
            s2 = new Slot(ImageIO.read(new File("Cherry.png")), s2);
            s3 = new Slot(ImageIO.read(new File("Bar.png")), null);
        } catch (IOException ex) {
            Logger.getLogger(SlotTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
        s1 = null;
        s2 = null;
        s3 = null;
        sm = null;
    }

    @Test
    public void testGetIcon() {

        try {
            assertEquals(ImageIO.read(new File("Banana.png")), s1.getIcon());
            assertEquals(ImageIO.read(new File("Cherry.png")), s2.getIcon());
            assertEquals(ImageIO.read(new File("Bar.png")), s3.getIcon());
        } catch (IOException ex) {
            Logger.getLogger(SlotTest.class.getName()).log(Level.SEVERE, null, ex);
            fail("Exception caught " + ex.getLocalizedMessage());
        }
    }

    @Test
    public void testIcon() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
