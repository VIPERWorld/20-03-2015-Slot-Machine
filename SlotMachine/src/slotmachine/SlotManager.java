/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import GUI.SoundPlayer;
import GUI.soundNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Asma
 */
public class SlotManager {

    private final Slot slot1;
    private final Slot slot2;
    private final Slot slot3;
    private final SoundPlayer sp;
    Random r;

    public SlotManager() throws IOException {
        this.r = new Random();
        sp = new SoundPlayer();

        slot1 = new Slot(getRandomNumber());
        slot2 = new Slot(getRandomNumber());
        slot3 = new Slot(getRandomNumber());

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

    public void spin() {
        if (!slot1.isHold()) {
            slot1.setRandomImage(getRandomNumber());
        }
        if (!slot2.isHold()) {
            slot2.setRandomImage(getRandomNumber());
        }
        if (!slot3.isHold()) {
            slot3.setRandomImage(getRandomNumber());
        }

        checkCombos();

    }

    public boolean checkCombos() {
        if (this.hasThreeInARow()) {
            System.out.println("Three in a row");
            sp.playSound(soundNames.THREE_IN_A_ROW);
            return true;

        } else if (hasTwoInARow()) {
            System.out.println("Two in a row");
            sp.playSound(soundNames.TWO_IN_A_ROW);
            return true;
        }
        return false;
    }

    private int getRandomNumber() {
        return r.nextInt(Slot.getImagePaths().length);
    }

    private boolean hasThreeInARow() {
        ArrayList<String> validIcons = new ArrayList<>(3);
        validIcons.add("Lucky7.png");
        validIcons.add("BigWin.png");
        validIcons.add("Bar.png");
        return getSlot1().equals(getSlot2()) && getSlot2().equals(getSlot3()) && validIcons.contains(getSlot3().getImageName());
    }

    private boolean hasTwoInARow() {
        return getSlot1().equals(getSlot2()) || getSlot2().equals(getSlot3()) && getSlot3().getImageName().equals("Cherry.png");
    }

}
