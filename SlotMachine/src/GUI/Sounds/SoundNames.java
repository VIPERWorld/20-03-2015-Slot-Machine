/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Sounds;

import java.net.URL;

/**
 *
 * @author Loek
 */
public enum SoundNames {

    /**
     * Sound played when the combo is 2 cherries.
     */
    TWO_IN_A_ROW("Combo_2x.wav"),
    /**
     * Sound played when combo is 3 bars, bigwins or lucky7s.
     */
    THREE_IN_A_ROW("Combo_3x.wav");

    private final String fileName;

    /**
     * Creates a URL to the soundfile.
     *
     * @return URL of the soundfile.
     */
    public URL getPath() {
        return this.getClass().getResource("/GUI/Sounds/" + fileName);
    }

    private SoundNames(String s) {
        this.fileName = s;
    }

}
