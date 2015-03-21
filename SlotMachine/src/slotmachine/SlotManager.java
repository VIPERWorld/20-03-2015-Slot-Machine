/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Asma
 */
public class SlotManager {

    private Slot slot1;
    private Slot slot2;
    private Slot slot3;

    public SlotManager() throws IOException {

        slot1 = new Slot(getRandomImage(), slot2);
        slot2 = new Slot(getRandomImage(), slot3);
        slot3 = new Slot(getRandomImage(), null);
        
        
        Icon i = new ImageIcon(ImageIO.read(getClass().getResource("/GUI/Images/Banana.png")));
 

    }

    private BufferedImage getRandomImage() {
        String[] imagePaths = new String[]{"Banana.png", "Bar.png", "BigWin.png", "Cherry.png", "Grape.png", "Lemon.png", "Lucky7.png", "Melon.png", "Orange.png"};
        Random r = new Random();
        try {
            return ImageIO.read(getClass().getResource("/GUI/Images/" + imagePaths[r.nextInt(imagePaths.length)]));
        } catch (IOException ex) {
            Logger.getLogger(SlotManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Slot getSlot1() {
        return slot1;
    }

    public Slot getSlot2() {
        return slot2;
    }

    public Slot getSlot3() {
        return slot3;
    }

    void spin() {
        slot1.setIcon(getRandomImage());
        slot2.setIcon(getRandomImage());
        slot3.setIcon(getRandomImage());

        checkCombos();

    }

    public String checkCombos() {
        if (slot1.equals(slot2.getIcon()) && slot2.equals(slot3.getIcon())) {
            return "Three in a row!";
        } else if (slot1.equals(slot2.getIcon()) || slot2.equals(slot3.getIcon())) {
            return "Two in a row!";
        }
        return "None in a row";
    }

}
