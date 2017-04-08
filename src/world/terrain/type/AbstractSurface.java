package world.terrain.type;


import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by epasquale on 3/24/17.
 */
public abstract class AbstractSurface extends Component {

    private static boolean initialized;
    private final ImageIcon mImageIcon;
    private static final Map<String, AbstractSurface> mTypes = new HashMap<>();
    private SoundPlayer soundPlayer = new SoundPlayer();


    /**
     * Types initialization
     */
    public static void initialize() {
        initialized = true;

        initialize(new Grass(), new Stone());
    }

    private static void initialize(final AbstractSurface... types) {
        for (AbstractSurface type : types) {
            mTypes.put(type.getKey(), type);
        }
    }

    /**
     * Default constructor
     */
    public AbstractSurface() {
        mImageIcon = new ImageIcon(getFilePath());
    }

    public ImageIcon getImageIcon() {
        return mImageIcon;
    }

    public abstract String getKey();

    public void playSound() {
        soundPlayer.play();
    }

    protected abstract String getSoundPath();

    abstract URL getFilePath();

    /**
     * Gets an {@link AbstractSurface AbstractSurface} by it's key
     *
     * @param key the key
     * @return the {@link AbstractSurface AbstractSurface} instance
     */
    public static AbstractSurface getTypeByKey(final String key) {
        if (!initialized) {
            initialize();
        }

        return mTypes.get(key);
    }

    @Override
    public int getWidth() {
        return mImageIcon.getIconWidth();
    }

    @Override
    public int getHeight() {
        return mImageIcon.getIconHeight();
    }

    private final class SoundPlayer {

        private void play() {
            final InputStream inputStream = getClass().getResourceAsStream(getSoundPath());
            final AudioStream audioStream;
            try {
                audioStream = new AudioStream(inputStream);
                if (AudioPlayer.player.isAlive()) {
                    AudioPlayer.player.start(audioStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
