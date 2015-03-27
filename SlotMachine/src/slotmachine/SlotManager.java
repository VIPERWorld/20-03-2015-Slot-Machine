package slotmachine;

import GUI.SlotGUI;
import GUI.Sounds.SoundNames;
import GUI.Sounds.SoundPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 *
 * SlotManager manages 3 slots. It makes them spin, checks for combos and tells
 * SoundPlayer to play appropiate sounds.
 *
 * @author Loek
 */
public class SlotManager extends Observable {

    private final Slot slot1;
    private final Slot slot2;
    private final Slot slot3;
    private final Random r;
    private final SoundPlayer soundPlayer;
    private SlotGUI gui;

    /**
     * Initializes 3 slots with random images.
     *
     * @throws IOException
     */
    public SlotManager() throws IOException {
        soundPlayer = new SoundPlayer();
        this.r = new Random();
        slot1 = new Slot(getRandomNumber());
        slot2 = new Slot(getRandomNumber());
        slot3 = new Slot(getRandomNumber());
        this.setChanged();
        this.notifyObservers();

    }

    public void setGui(SlotGUI gui) {
        this.gui = gui;
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
        boolean slot1hold = false;
        boolean slot2hold = false;
        boolean slot3hold = false;
        if (!slot1.isHold()) {
            slot1.setRandomImage(getRandomNumber());
        } else {
            slot1hold = true;
        }
        if (!slot2.isHold()) {
            slot2.setRandomImage(getRandomNumber());
        } else {
            slot2hold = true;
        }
        if (!slot3.isHold()) {
            slot3.setRandomImage(getRandomNumber());
        } else {
            slot3hold = true;
        }
        checkCombos();

        if (slot1hold) {
            gui.click(gui.getSlot1Hold());
        }
        if (slot2hold) {
            gui.click(gui.getSlot2Hold());
        }
        if (slot3hold) {
            gui.click(gui.getSlot3Hold());
        }

        this.setChanged();
        this.notifyObservers();

    }

    /**
     * Checks slots if they are equal and if they have the right icons, returns
     * a string based on the combo.
     *
     * @return a string based on the combo.
     */
    public String checkCombos() {
        if (this.hasThreeInARow()) {
            soundPlayer.playSound(SoundNames.THREE_IN_A_ROW);
            return "Three in a row!";

        } else if (hasTwoInARow()) {
            soundPlayer.playSound(SoundNames.TWO_IN_A_ROW);
            return "Two in a row!";
        }
        gui.getPlayButton().setEnabled(true);
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
        validIcons.add("Cherry.png");
        return ((getSlot1().equals(getSlot2()) && getSlot2().equals(getSlot3()))
                || (getSlot1().isHold() && getSlot2().isHold() && getSlot1().getImageName().equals(getSlot2().getImageName()) && getSlot2().getImageName().equals(getSlot3().getImageName()))
                || (getSlot2().isHold() && getSlot1().getImageName().equals(getSlot2().getImageName()) && getSlot2().getImageName().equals(getSlot3().getImageName()))
                || (getSlot2().isHold() && getSlot3().isHold() && getSlot1().getImageName().equals(getSlot2().getImageName()) && getSlot2().getImageName().equals(getSlot3().getImageName()))
                || (getSlot1().isHold() && getSlot3().isHold() && getSlot1().getImageName().equals(getSlot2().getImageName()) && getSlot2().getImageName().equals(getSlot3().getImageName())))
                && !(getSlot1().isHold() && getSlot2().isHold() && getSlot3().isHold())
                && validIcons.contains(getSlot3().getImageName());
    }

    private boolean hasTwoInARow() {
        return (    getSlot1().equals(getSlot2()) 
                ||  getSlot2().equals(getSlot3()) 
                || (getSlot1().isHold() && !getSlot2().isHold() && getSlot2().getImageName().equals(getSlot1().getImageName()))
                || (getSlot2().isHold() && !getSlot1().isHold() && getSlot1().getImageName().equals(getSlot2().getImageName()))
                || (getSlot3().isHold() && !getSlot2().isHold() && getSlot2().getImageName().equals(getSlot3().getImageName()))
                || (getSlot2().isHold() && !getSlot3().isHold() && getSlot3().getImageName().equals(getSlot2().getImageName())))
                && getSlot2().getImageName().equals("Cherry.png");
    }

}
