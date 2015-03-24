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
public enum soundNames {

    TWO_IN_A_ROW("Combo_x2.wav"),
    THREE_IN_A_ROW("Combo_x3.wav");

    private final String fileName;

    public URL getPath() {
        return getClass().getResource("/GUI/Sounds/" + fileName);
    }

    private soundNames(String s) {
        this.fileName = s;
    }

}
