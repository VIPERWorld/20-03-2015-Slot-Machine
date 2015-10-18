/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slotmachine;

import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Loek
 */
public final class Slot {

    private static final String[] imagePaths = new String[]{"Banana.png", "Bar.png", "BigWin.png", "Cherry.png", "Grape.png", "Lemon.png", "Lucky7.png", "Melon.png", "Orange.png"};

    /**
     * Get the array of valid imagefile names.
     *
     * @return array of image names.
     */
    public static String[] getImagePaths() {
        return imagePaths;
    }

    private Icon icon;
    private boolean hold = false;
    private String imageName;

    /**
     * Constructor.
     *
     * @param i random integer to set slot image to. Corresponds with place in
     * imagePaths array.
     */
    public Slot(int i) {
        setRandomImage(i);
    }

    /**
     *
     * @return image name of the slot. As in imagePaths.
     */
    public String getImageName() {
        return imageName;
    }

    /**
     *
     * @return icon of the slot.
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Set this slot not to change image when spin() is called.
     *
     * @param hold true or false, depending on if the slot should spin.
     */
    public void setHold(boolean hold) {
        this.hold = hold;
    }

    /**
     * Sets a specific image determined by a random integer.
     *
     * @param i random integer to set image to.
     */
    public void setRandomImage(int i) {
        setSpecificImage(i);
    }

    /**
     * Sets image. Gets imagename from imagePaths array.
     *
     * @param i
     */
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
        return Objects.equals(this.getImageName(), other.getImageName());
    }

    /**
     * Return is hold.
     *
     * @return true if slot is held, false if not.
     */
    public boolean isHold() {
        return hold;
    }

}
