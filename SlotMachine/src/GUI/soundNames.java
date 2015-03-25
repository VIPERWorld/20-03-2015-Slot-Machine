/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;

/**
 *
 * @author Loek
 */
public enum SoundNames {

    TWO_IN_A_ROW("Combo_2x.wav"),
    THREE_IN_A_ROW("Combo_3x.wav");

    private final String fileName;

    public URL getPath() {
        return this.getClass().getResource("/GUI/Sounds/" + fileName);
    }

    private SoundNames(String s) {
        this.fileName = s;
    }

}
