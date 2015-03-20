/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import GUI.SlotPanel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Asma
 */
public class SlotManager {

    private Slot slot1;
    private Slot slot2;
    private Slot slot3;
    private SlotPanel panel;

    public SlotManager() throws IOException {

        slot1 = new Slot(ImageIO.read(getRandomImage()), slot2);
        slot2 = new Slot(ImageIO.read(getRandomImage()), slot3);
        slot3 = new Slot(ImageIO.read(getRandomImage()), null);
        
    }

    private File getRandomImage() {
        String[] imagePaths = new String[]{"Banana.png", "Bar.png", "BigWin.png", "Cherry.png", "Grape.png", "Lemon.png", "Lucky7.png", "Melon.png", "Orange.png"};
        Random r = new Random();
        return new File(imagePaths[r.nextInt(imagePaths.length)]);
    }

}
