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
 * @author Asma
 */
public class SlotMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SlotManager sm = new SlotManager();
        } catch (IOException ex) {
            Logger.getLogger(SlotMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                SlotGUI sgui = new SlotGUI();
                sgui.setLocationRelativeTo(null);
                sgui.setTitle("Slot Machines");
                sgui.setVisible(true);
            }
        });
        
        
    }
    
}
