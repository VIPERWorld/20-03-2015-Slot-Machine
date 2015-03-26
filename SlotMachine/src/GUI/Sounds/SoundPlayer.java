package GUI.Sounds;

import GUI.SoundNames;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * Useful for playing sounds.
 * @author Loek
 */
public class SoundPlayer {

    
    /**
     * 
     * @param sn Enum of a sound name.
     */
    public void playSound(SoundNames sn) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sn.getPath());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
