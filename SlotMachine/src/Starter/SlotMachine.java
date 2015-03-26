/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import GUI.SlotGUI;
import GUI.Sounds.SoundPlayer;
import java.io.IOException;
import slotmachine.SlotManager;

/**
 *
 * @author Asma
 */
public class SlotMachine {

    private final SlotGUI slotGUI;
    private final SoundPlayer soundPlayer;
    private final SlotManager slotManager;

    public SlotMachine() throws IOException {
        this.slotManager = new SlotManager(this);
        this.soundPlayer = new SoundPlayer();
        this.slotGUI = new SlotGUI(this);

    }

    public SlotGUI getSlotGUI() {
        return slotGUI;
    }

    public SoundPlayer getSoundPlayer() {
        return soundPlayer;
    }

    public SlotManager getSlotManager() {
        return slotManager;
    }

}
