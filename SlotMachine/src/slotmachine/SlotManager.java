/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Asma
 */
public class SlotManager {

    private final Slot slot1;
    private final Slot slot2;
    private final Slot slot3;
    Random r;

    public SlotManager() throws IOException {
        this.r = new Random();
        
        
        slot1 = new Slot(r.nextInt(getRandomNumber()));
        slot2 = new Slot(r.nextInt(getRandomNumber()));
        slot3 = new Slot(r.nextInt(getRandomNumber()));

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

        System.out.println(checkCombos());

    }

    public String checkCombos() {
        if (slot1.equals(slot2) && slot2.equals(slot3)) {
            return "Three in a row!";
        } else if (slot1.equals(slot2) || slot2.equals(slot3)) {
            return "Two in a row!";
        }
        return "None in a row";
    }
    
    private int getRandomNumber(){
        return r.nextInt(Slot.getImagePaths().length);
    }

}
