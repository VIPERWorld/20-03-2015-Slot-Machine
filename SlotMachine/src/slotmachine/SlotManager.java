package slotmachine;

import GUI.SoundPlayer;
import GUI.soundNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * SlotManager manages 3 slots. It makes them spin, checks for combos and tells SoundPlayer to play appropiate sounds.
 * @author Loek
 */
public class SlotManager {

    private final Slot slot1;
    private final Slot slot2;
    private final Slot slot3;
    private final SoundPlayer sp;
    private Random r;

    /**
     * Initializes 3 slots with random images, SoundPlayer and Random.
     * @throws IOException 
     */
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

    /**
     * Checks slot if they are set to hold and spins them if not.
     */
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

    /**
     * Checks slots if they are equal and if they have the right icons, returns a string based on the combo.
     * @return a string based on the combo.
     */
    public String checkCombos() {
        if (this.hasThreeInARow()) {
            sp.playSound(soundNames.THREE_IN_A_ROW);
            return "Three in a row!";

        } else if (hasTwoInARow()) {
            sp.playSound(soundNames.TWO_IN_A_ROW);
            return "Two in a row!";
        }
       return "None in a row!";
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
        return (getSlot1().equals(getSlot2()) || getSlot2().equals(getSlot3())) && getSlot2().getImageName().equals("Cherry.png");
    }

}
