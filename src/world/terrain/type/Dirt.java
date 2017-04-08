package world.terrain.type;

import java.net.URL;

/**
 * Created by danielmaldonado on 4/8/17.
 */
public class Dirt extends AbstractSurface {

    public static final String KEY = "D";
    private static final String PATH = "/dirt_0.png";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    protected String getSoundPath() {
        return "/sound/footstep_dirt.wav";
    }

    @Override
    URL getFilePath() {
        return getClass().getResource(PATH);
    }
}
