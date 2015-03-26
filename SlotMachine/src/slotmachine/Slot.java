/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slotmachine;

import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Loek
 */
public class Slot {

    private static final String[] imagePaths = new String[]{"Banana.png", "Bar.png", "BigWin.png", "Cherry.png", "Grape.png", "Lemon.png", "Lucky7.png", "Melon.png", "Orange.png"};

    public static String[] getImagePaths() {
        return imagePaths;
    }

    private Icon icon;
    private boolean hold = false;
    private String imageName;

    public Slot(int i) {
        setRandomImage(i);
    }

    public String getImageName() {
        return imageName;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public final void setRandomImage(int i) {
        setSpecificImage(i);
    }

    public void setSpecificImage(int i) {
        this.icon = new ImageIcon(getClass().getResource("/GUI/Images/" + imagePaths[i]));
        imageName = imagePaths[i];
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.imageName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Slot other = (Slot) obj;
        if (!Objects.equals(this.getImageName(), other.getImageName())) {
            return false;
        }
        return !this.isHold() && !((Slot) obj).isHold();
    }

    public boolean isHold() {
        return hold;
    }

}
