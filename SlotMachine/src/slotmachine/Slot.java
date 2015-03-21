/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Asma
 */
public class Slot {

    private Image icon;
    private boolean hold = false;

    public Slot(BufferedImage icon, Slot slotToRight) {
        this.icon = icon;
    }

    public Image getIcon() {
        return icon;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }
    
    public void setIcon(BufferedImage icon) {
        this.icon = icon;
    }

}
