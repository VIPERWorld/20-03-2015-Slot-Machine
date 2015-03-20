/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.awt.image.BufferedImage;

/**
 *
 * @author Asma
 */
public class Slot {
    private final BufferedImage icon;
    private final Slot slotToRight;

    public Slot(BufferedImage icon, Slot slotToRight) {
        this.icon = icon;
        this.slotToRight = slotToRight;
    }

    public BufferedImage getIcon() {
        return icon;
    }

    public Slot getSlotToRight() {
        return slotToRight;
    }
    
    
    
}
