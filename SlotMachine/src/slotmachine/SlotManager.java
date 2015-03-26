package slotmachine;

import GUI.SoundNames;
import Starter.SlotMachine;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * SlotManager manages 3 slots. It makes them spin, checks for combos and tells
 * SoundPlayer to play appropiate sounds.
 *
 * @author Loek
 */
public class SlotManager {

    private final Slot slot1;
    private final Slot slot2;
    private final Slot slot3;
    private final SlotMachine slotMachine;
    private final Random r;

    /**
     * Initializes 3 slots with random images, SoundPlayer and Random.
     *
     * @param sm
     * @throws IOException
     */
    public SlotManager(SlotMachine sm) throws IOException {
        this.r = new Random();
        slotMachine = sm;

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
        } else {
            slotMachine.getSlotGUI().click(slotMachine.getSlotGUI().getSlot1Hold());
        }
        if (!slot2.isHold()) {
            slot2.setRandomImage(getRandomNumber());
        } else {
            slotMachine.getSlotGUI().click(slotMachine.getSlotGUI().getSlot2Hold());
        }
        if (!slot3.isHold()) {
            slot3.setRandomImage(getRandomNumber());
        } else {
            slotMachine.getSlotGUI().click(slotMachine.getSlotGUI().getSlot3Hold());

        }

        checkCombos();

    }

    /**
     * Checks slots if they are equal and if they have the right icons, returns
     * a string based on the combo.
     *
     * @return a string based on the combo.
     */
    public String checkCombos() {
        if (this.hasThreeInARow()) {
            slotMachine.getSoundPlayer().playSound(SoundNames.THREE_IN_A_ROW);
            return "Three in a row!";

        } else if (hasTwoInARow()) {
            slotMachine.getSoundPlayer().playSound(SoundNames.TWO_IN_A_ROW);
            return "Two in a row!";
        }
        slotMachine.getSlotGUI().getPlayButton().setEnabled(true);
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
        return getSlot1().equals(getSlot2()) && getSlot2().equals(getSlot3()) && validIcons.contains(getSlot3().getImageName());
    }

    private boolean hasTwoInARow() {
        return (getSlot1().equals(getSlot2()) || getSlot2().equals(getSlot3())) && getSlot2().getImageName().equals("Cherry.png");
    }

}
