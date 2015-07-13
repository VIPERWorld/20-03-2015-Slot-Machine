package slotmachine;

import GUI.SlotGUI;
import GUI.Sounds.SoundNames;
import GUI.Sounds.SoundPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * SlotManager manages 3 slots. It makes them spin, checks for combos and tells
 * SoundPlayer to play the appropriate sounds.
 *
 * @author Loek
 */
public class SlotManager extends Observable {

    private final Slot slot1;
    private final Slot slot2;
    private final Slot slot3;
    private final SoundPlayer soundPlayer;
    private Thread sound;
    private SlotGUI gui;

    /**
     * Initializes 3 slots with random images.
     *
     * @throws IOException
     */
    public SlotManager() throws IOException {
        soundPlayer = new SoundPlayer(this);
        
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
            soundPlayer.setSoundClip(SoundNames.THREE_IN_A_ROW);
            playSound();
            gui.addPointsThreeInARow();
            return "Three in a row!";
            

        } else if (hasTwoInARow()) {
            soundPlayer.setSoundClip(SoundNames.TWO_IN_A_ROW);
            playSound();
            gui.addPointsTwoInARow();
            return "Two in a row!";
        }
        gui.getPlayButton().setEnabled(true);
        gui.subtractPoints();
        return "None in a row!";
    }

    private int getRandomNumber() {
        Random r = new Random();
        return r.nextInt(Slot.getImagePaths().length);
    }

    private boolean hasThreeInARow() {
        ArrayList<String> validIcons = new ArrayList<>(3);
        validIcons.add("Lucky7.png");
        validIcons.add("BigWin.png");
        validIcons.add("Bar.png");
        validIcons.add("Cherry.png");
        Slot sslot1 = getSlot1();
        Slot sslot2 = getSlot2();
        Slot sslot3 = getSlot3();

        // return false if all of the slots are held
        if (sslot1.isHold() && sslot2.isHold() && sslot3.isHold()) {
            return false;
        } // return false if an invalid image is held
        else if (!validIcons.contains(sslot3.getImageName())) {
            return false;
        } else {
            // return true if all the images match
            return sslot1.equals(sslot2) && sslot2.equals(sslot3);
        }
    }

    private boolean hasTwoInARow() {
        Slot sslot1 = getSlot1();
        Slot sslot2 = getSlot2();
        Slot sslot3 = getSlot3();

        //Return false if there isn't a Cherry image
        if (!sslot2.getImageName().equals("Cherry.png")) {
            return false;
        }

        //Returns false if all slots are held.
        if (sslot1.isHold() && sslot2.isHold() && sslot3.isHold()) {
            return false;
        }

        //Return false if there are no two same icons and hold status are valid in a row.
        if (sslot1.isHold()) {
            if (sslot2.isHold()) {
                return false;
            }
            return sslot1.equals(sslot2);
        }
        if (sslot2.isHold()) {
            if (sslot1.isHold() || sslot3.isHold()) {
                return false;
            }
            return sslot1.equals(sslot2)
                    || sslot2.equals(sslot3);
        }
        return sslot3.equals(sslot2) || sslot1.equals(sslot2);

    }

    public void finishedPlaying() {
        gui.finishedPlaying();
    }

    private void playSound() {
        sound = new Thread(soundPlayer);
        sound.start();
    }

}
