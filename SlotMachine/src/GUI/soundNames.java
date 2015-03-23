/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;

/**
 *
 * @author Asma
 */
public enum soundNames {

    TWO_IN_A_ROW("Multicast_x3.wav"),
    THREE_IN_A_ROW("Multicast_x4.wav");

    private String fileName;

    public URL getPath() {
        return getClass().getResource("/GUI/Sounds/" + fileName);
    }

    private soundNames(String s) {
        this.fileName = s;
    }

}
