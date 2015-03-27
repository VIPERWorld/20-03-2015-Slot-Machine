/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import GUI.SlotGUI;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import slotmachine.SlotManager;

/**
 *
 * @author Loek
 */
public class Starter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SlotManager sm;
            SlotGUI gui;
            sm = new SlotManager();
            gui = new SlotGUI(sm);
            sm.setGui(gui);
            sm.addObserver(gui);
            SwingUtilities.invokeLater(() -> {
                gui.setVisible(true);
            });
        } catch (IOException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
