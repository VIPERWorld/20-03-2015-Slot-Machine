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
            SlotMachine sm = new SlotMachine();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    sm.getSlotGUI().setLocationRelativeTo(null);
                    sm.getSlotGUI().setVisible(true);
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
