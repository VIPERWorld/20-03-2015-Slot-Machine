package GUI.Sounds;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import slotmachine.SlotManager;

/**
 *
 * Useful for playing sounds.
 *
 * @author Loek
 */
public class SoundPlayer implements Runnable{

    private final SlotManager sm;
    private SoundNames soundClip;
    private AudioInputStream audioInputStream;
    private Clip clip;

    public SoundPlayer(SlotManager sm){
        this.soundClip = null;
        this.sm = sm;
        this.clip = null;
    }

    public void setSoundClip(SoundNames soundClip) {
        this.soundClip = soundClip;
    }

    private void playSound(SoundNames sn) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(sn.getPath());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            while(clip.getMicrosecondLength() != clip.getMicrosecondPosition()){}
            sm.finishedPlaying();

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            Logger.getLogger(SoundPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        playSound(soundClip);
    }

}
