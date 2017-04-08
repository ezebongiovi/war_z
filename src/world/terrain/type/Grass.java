package world.terrain.type;

import java.net.URL;

/**
 * Created by epasquale on 3/23/17.
 */
public class Grass extends AbstractSurface {

    public static final String KEY = "G";
    private static final String PATH = "/grass.png";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    protected String getSoundPath() {
        return "/sound/footstep_grass.wav";
    }

    @Override
    URL getFilePath() {
        return getClass().getResource(PATH);
    }
}